package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;

public class Exception implements Serializable {
	private static final long serialVersionUID = 7473224003715116061L;
	private LocalDate date; 
	private Pharmacy pharmacy;

	//constructor
	public Exception(LocalDate fecha, Pharmacy farmacia) {
		this.setPharmacy(farmacia);
		this.setDate(fecha);
	}
		
	//getter & setters
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate fecha) {
		this.date = fecha;
	}
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	
	public void setPharmacy(Pharmacy farmacia) {
		this.pharmacy = farmacia;
	}
}