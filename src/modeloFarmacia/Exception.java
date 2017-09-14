package modeloFarmacia;

import java.time.LocalDate;

public class Exception {
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