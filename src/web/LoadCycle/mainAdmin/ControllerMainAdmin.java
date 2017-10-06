package web.LoadCycle.mainAdmin;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.Cycle;
import modeloFarmacia.Exception;
import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;

public class ControllerMainAdmin extends Controller implements Serializable{
	private static final long serialVersionUID = 3583465022871249000L;
	
	private Sector actualSector;
	private LocalDate actualDateException;
	private Pharmacy actualPharmacyException;
	private String dateExceptionString;
	
	public List<Sector> getSectorList(){
		return PharmApp.store().getSectorList();
	}
	
	public List<Cycle> getCycles(){
		if (this.actualSector != null){
			return this.getActualSector().getCycles();
		} else {
			return null;
		}
	}
	
	//Agrega la excepcion al modelo
	public void saveException() {
		this.getActualSector()
				.findCycleWhithDate(getActualDateException())
				.addException(new Exception(this.getActualDateException(), this.getActualPharmacyException()));
	}
	
	public List<Pharmacy> getPharmacyCycleList(){
		return this.getActualSector()
				.findCycleWhithDate(getActualDateException())
				.getPharmacysInCycle();
	}
	
	public List<Exception> getExceptions(){
		return getActualSector().getCycles().stream()
				.flatMap(c -> c.getExceptions().stream())
				.collect(Collectors.toList());
	}
	
	public boolean hasDateExceptionSelect() {
		return this.dateExceptionString != null;
	}
	
	public boolean hasSectorSelected() {
		return this.getActualSector() != null;
	}
	
//Getters y Setters
	
	public Sector getActualSector(){
		return this.actualSector;
	}
	public void setActualSector(Sector actualSector){
		this.actualSector = actualSector;
	}


	public Pharmacy getActualPharmacyException() {
		return actualPharmacyException;
	}

	public void setActualPharmacyException(Pharmacy actualPharmacyException) {
		this.actualPharmacyException = actualPharmacyException;
	}

	public LocalDate getActualDateException() {
		return actualDateException;
	}

	public void setActualDateException(LocalDate actualDateException) {
		this.actualDateException = actualDateException;
	}

	public String getDateExceptionString() {
		return dateExceptionString;
	}

	public void setDateExceptionString(String dateExceptionString) {
		this.actualDateException = LocalDate.parse(dateExceptionString);
		this.dateExceptionString = dateExceptionString;
	}
}
