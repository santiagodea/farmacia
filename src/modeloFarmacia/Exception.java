package modeloFarmacia;

import java.time.LocalDate;

public class Exception {
	private LocalDate fecha; 
	private Pharmacy farmacia;

	//constructor
	public Exception(LocalDate fecha, Pharmacy farmacia) {
		this.setFarmacia(farmacia);
		this.setFecha(fecha);
	}
		
		
	//getter & setters
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Pharmacy getFarmacia() {
		return farmacia;
	}
	
	public void setFarmacia(Pharmacy farmacia) {
		this.farmacia = farmacia;
	}
}