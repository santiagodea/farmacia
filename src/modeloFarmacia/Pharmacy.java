package modeloFarmacia;

import java.util.ArrayList;
import java.util.Collection;

public class Pharmacy extends InfoStandard{
	private Collection<ObraSocial> obrasSociales = new ArrayList<>();
	
	//constructor
	public Pharmacy(String name,String address, int landphone, int alternativePhone) {
		super(name, address , landphone, alternativePhone);
	}
	
	//getters & setters

	public Collection<ObraSocial> getObrasSociales() {return obrasSociales;}
	public void setObrasSociales(Collection<ObraSocial> obrasSociales) {this.obrasSociales = obrasSociales;}
	
	
	public void agregarObraSocial(ObraSocial unaObra) {
		this.getObrasSociales().add(unaObra);
	}
	
}
