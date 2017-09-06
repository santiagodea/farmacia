package modeloFarmacia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Cycle {
	private Collection<Exception> exceptions = new ArrayList<>();
	private LocalDateTime dateStart;
	private LocalDateTime dateEnd;
	private Collection<Pharmacy> pharmacy = new ArrayList<>(); 
	
//constructor
	public Cycle(LocalDateTime dateStart, LocalDateTime dateEnd){
		this.setDateStart(dateStart);
		this.setDateEnd(dateEnd);
	}

	
	
//setters y getters
	public Collection<Exception> getExceptions() {
		return exceptions;
	}

	
	public void setExceptions(Collection<Exception> exceptions) {
		this.exceptions = exceptions;
	}



	public LocalDateTime getDateStart() {
		return dateStart;
	}



	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}



	public LocalDateTime getDateEnd() {
		return dateEnd;
	}



	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}



	public Collection<Pharmacy> getPharmacy() {
		return pharmacy;
	}



	public void setPharmacy(Collection<Pharmacy> pharmacy) {
		this.pharmacy = pharmacy;
	}
}