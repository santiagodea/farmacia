package modeloFarmacia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Cycle {
	private Collection<Exception> exceptions = new ArrayList<>();
	private LocalDate dateStart;
	private LocalDate dateEnd;
	
//constructor
	public Cycle(LocalDate dateStart, LocalDate dateEnd){
		this.setDateStart(dateStart);
		this.setDateEnd(dateEnd);
	}
	
	
	
	public void addException(Exception aException) {
		this.getExceptions().add(aException);
	}
	
//	public void reemplaceException(aException) {
//		//TODO
//	}
	
	public boolean canIAddException(Exception aException) {
		return this.isInRange(aException);
		// TODO tiene que estan entres las fechas de inicio y fin.
	}
	public boolean sesolapa(Cycle aCycle) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isInRange(Exception aException) {
		LocalDate tempDate = aException.getDate();
		
		
		return (this.getDateStart().isBefore(tempDate) ||this.getDateStart().isEqual(tempDate))  && 
				(this.getDateEnd().isAfter(tempDate) ||this.getDateEnd().isAfter(tempDate));
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