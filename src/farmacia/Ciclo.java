package farmacia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Ciclo {
	private Collection<FarmaciaFecha> farmaciasEnCiclo = new ArrayList<>();
	
	public Collection<FarmaciaFecha> getFarmaciasEnCiclo() {
		return farmaciasEnCiclo;
	}
	public void setFarmaciasEnCiclo(Collection<FarmaciaFecha> farmacias) {
		this.farmaciasEnCiclo = farmacias;
	}
	
	public Collection<Farmacia> coleccionDeFarmacias(){
		return this.getFarmaciasEnCiclo().stream().map(f -> f.getFarmacia()).distinct().collect(Collectors.toList());
	}
	
	public void agregarFarmaciaAlCiclo(LocalDate fecha, Farmacia farmacia) {
		this.getFarmaciasEnCiclo().add(new FarmaciaFecha(fecha,farmacia));
	}
	
	
	
	
	
	public boolean sePuedeAgregarFarmacia(Farmacia unaFarmacia) {
		return (!this.coleccionDeFarmacias().contains(unaFarmacia));
	}
}
