package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Cycle implements Serializable {
	private static final long serialVersionUID = 3718085655203446371L;
	private Collection<Exception> exceptions = new ArrayList<>();
	private LocalDate dateStart; // automaticamente al crearlo se asigna la fecha siguiente al ultimo siglo vigente.
	private LocalDate dateEnd;
	
//constructor
	public Cycle(LocalDate dateStart, LocalDate dateEnd){
		this.setDateStart(dateStart);
		this.setDateEnd(dateEnd);
	}
	
	
	//agrega una excepcion al ciclo, si es que puede
	public void addException(Exception aException) {
		
		if (this.canIAddException(aException)){
			
			this.addOrReplaceException(aException);
		}
		else {
			throw new RuntimeException("La Excepcion no no se puede agregar al ciclo");
		}
	}
	
	public void addOrReplaceException(Exception aException) {
		Exception theException = this.findException(aException) ;
		
		if(theException == null){
			this.getExceptions().add(aException);
		}
		else {
			//this.getExceptions().remove(theException);
			theException.setPharmacy(aException.getPharmacy());
			//this.getExceptions().add(theException);
		}
	}
	
	private Exception findException(Exception aException) {
		return this.getExceptions().stream().filter(e -> e.getDate().equals(aException.getDate())).findAny().get();
	}


	//se fija si pude agregar una excepcion al ciclo, tiene que estan en rango
	public boolean canIAddException(Exception aException) {
		return this.includeDate(aException.getDate());
	}
		
//	//valida si una excepcion estan entre la fecha de inicio y la de fin del ciclo.
//	private boolean isInRange(Exception aException) {
//		LocalDate tempDate = aException.getDate();
//			
//		return ;
//	}

	public boolean includeDate(LocalDate date) {
		return  (this.getDateStart().isBefore(date) ||this.getDateStart().isEqual(date))  && 
				(this.getDateEnd().isAfter(date) || this.getDateEnd().isEqual(date));
	}

	
	public Pharmacy getShiftPharmacy(List<Pharmacy> pharmacyList, LocalDate actualDate) {
		Pharmacy pharmacy;
		if(this.existExceptionWithDate(actualDate)){
			pharmacy = this.getExceptionDate(actualDate).getPharmacy();
		} else {
			pharmacy = pharmacyList.get(this.getPharmacyIndex(pharmacyList, actualDate));
		}
		return  pharmacy;
	}
	
	private int getPharmacyIndex(List<Pharmacy> pharmacyList, LocalDate actualDate){
		int days = Math.toIntExact(ChronoUnit.DAYS.between(this.dateStart, actualDate));
		int index;
		if (days == 0){
			index = 0;
		} else {
			index = days % pharmacyList.size();
		}
		return index;
	}

	private Exception getExceptionDate(LocalDate actualDate) {
		return this.getExceptions().stream().filter(e -> e.getDate().equals(actualDate)).findFirst().get();
	}


	private boolean existExceptionWithDate(LocalDate actualDate) {
		return this.getExceptions().stream().anyMatch(e -> e.getDate().equals(actualDate));
	}


	//setters y getters
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

}