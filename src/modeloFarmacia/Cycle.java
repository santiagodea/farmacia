package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class Cycle implements Serializable {
	private static final long serialVersionUID = 3718085655203446371L;
	private Collection<Exception> exceptions = new ArrayList<>();
	private LocalDate dateStart; // automaticamente al crearlo se asigna la fecha siguiente al ultimo siglo vigente.
	private LocalDate dateEnd;
	private List<Pharmacy> pharmacysInCycle = new ArrayList<>();
	private Sector sector;

//constructor



	public Cycle(LocalDate dateStart, LocalDate cycleEndDate, Sector sector2) {
		this.setDateStart(dateStart);
		this.setDateEnd(cycleEndDate);
		this.sector = sector2;
	}


//Methods

	//agrega una excepcion al ciclo, si es que puede
	public void addException(Exception aException) {
		if (this.canIAddException(aException)){
			this.addOrReplaceException(aException);
		}
		else {
			throw new RuntimeException("La Excepcion no se puede agregar al ciclo");
		}
	}

	public void addOrReplaceException(Exception aException) {
		  Optional<Exception> theException = this.findException(aException) ;

		if(!theException.isPresent()){
			aException.setCycle(this);
			this.getExceptions().add(aException);
		}
		else {
			theException.get().setPharmacy(aException.getPharmacy());
		}
	}

	private  Optional<Exception> findException(Exception aException) {
		return this.getExceptions().stream()
									.filter(e -> e.getDate().equals(aException.getDate()))
									.findAny();
	}


	//se fija si pude agregar una excepcion al ciclo, tiene que estan en rango
	public boolean canIAddException(Exception aException) {
		return this.includeDate(aException.getDate());
	}


	public boolean includeDate(LocalDate date) {
		return  (this.getDateStart().isBefore(date) ||this.getDateStart().isEqual(date))  &&
				(this.getDateEnd().isAfter(date) || this.getDateEnd().isEqual(date));
	}


	public Pharmacy getShiftPharmacy(LocalDate actualDate) {
		Pharmacy pharmacy;
		if(this.existExceptionWithDate(actualDate)){
			pharmacy = this.getExceptionDate(actualDate).getPharmacy();
		} else {
			pharmacy = this.getPharmacyWithOutException(actualDate);
		}
		return  pharmacy;
	}

	public Pharmacy getPharmacyWithOutException( LocalDate actualDate) {
		return this.getPharmacysInCycle().get(this.getPharmacyIndex(actualDate));
	}


	private int getPharmacyIndex(LocalDate actualDate){
		int days = Math.toIntExact(ChronoUnit.DAYS.between(this.dateStart, actualDate));
		return (days == 0) ? 0 :days % this.getPharmacysInCycle().size();
	}

	private Exception getExceptionDate(LocalDate actualDate) {
		return this.getExceptions().stream().filter(e -> e.getDate().equals(actualDate)).findFirst().get();
	}


	private boolean existExceptionWithDate(LocalDate actualDate) {
		return this.getExceptions().stream().anyMatch(e -> e.getDate().equals(actualDate));
	}

	public void addPharmacy(Pharmacy pharmacy) {
		this.getPharmacyList().add(pharmacy);
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


	public List<Pharmacy> getPharmacysInCycle() {
		return (this.pharmacysInCycle.isEmpty()) ? this.sector.getPharmacyList() : pharmacysInCycle;
	}


	public void setPharmacysInCycle(List<Pharmacy> pharmacysInCycle) {
		this.pharmacysInCycle = pharmacysInCycle;
	}

}
