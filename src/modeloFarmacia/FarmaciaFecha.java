package modeloFarmacia;

import java.time.LocalDate;

public class FarmaciaFecha {
	private LocalDate fecha;
	// ver bien como manejar las fechas 
	private Farmacia farmacia;
		
	//getter & setters
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Farmacia getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	//constructor
	public FarmaciaFecha(LocalDate fecha2, Farmacia farmacia2) {
		this.setFarmacia(farmacia2);
		this.setFecha(fecha2);
	}
}
