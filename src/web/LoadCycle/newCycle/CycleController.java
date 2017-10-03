package web.LoadCycle.newCycle;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.Cycle;
import modeloFarmacia.Exception;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;

public class CycleController implements Serializable{
	private static final long serialVersionUID = 3940621338505746999L;
	
	private Collection<Exception> exceptions = new ArrayList<>();
	private LocalDate dateStart; // automaticamente al crearlo se asigna la fecha siguiente al ultimo siglo vigente.
	private LocalDate dateEnd;
	private List<Pharmacy> pharmacyList = new ArrayList<>();
	
	
	private List<CheckControllerPharmacy> checked = new ArrayList<>();
	
	private Sector sector;
	

	public CycleController(Sector aSector) {
		this.setSector(aSector);
		this.setPharmacyList(aSector.getPharmacyList());
		this.setDateStart(getDateEndCycle());
	}
	
	private LocalDate getDateEndCycle() {
		return getSector().getCycles().get(getSector().getCycles().size() -1 ).getDateEnd();
	}

	public void fillChecked() {
		this.getPharmacyList().forEach(p -> this.getChecked().add(new CheckControllerPharmacy(p)));	
	}
	
	public void setCycleToBeUpdated(Cycle cycle) {
		this.setExceptions(cycle.getExceptions());
		this.setDateEnd(cycle.getDateEnd());
		this.setPharmacyList(cycle.getPharmacyList());
	}
	
	public void accept() {
	Cycle newCycle = this.buildCycle();
	newCycle.setPharmacyList(checked.stream().filter(c -> c.getChecked().equals(true)).map(c -> c.getPharmacy()).collect(Collectors.toList()));

	sector.getCycles().add(newCycle);
	
	}
	
	
	public Cycle buildCycle() {
	
	Cycle newCycle = new Cycle(getDateStart(), getDateEnd());

	newCycle.setExceptions(null);
	newCycle.setPharmacyList(getPharmacyList());
	return newCycle;
	
}
	
	//getters and setters
	public Collection<Exception> getExceptions() {
		return exceptions;
	}
	public void setExceptions(Collection<Exception> exceptions) {
		this.exceptions = exceptions;
	}
	public LocalDate getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDate getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}
	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}
	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}
	public List<CheckControllerPharmacy> getChecked() {
		return checked;
	}
	public void setChecked(List<CheckControllerPharmacy> checked) {
		this.checked = checked;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
}