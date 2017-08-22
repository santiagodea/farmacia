package farmacia;

import java.util.ArrayList;
import java.util.Collection;

public class Farmacia {
	private String nombre;
	private Integer telefono;
	private String direccion;
	private Collection<ObraSocial> obrasSociales = new ArrayList<>();
	
	//constructor
	public Farmacia(String unNombre, Integer unTel, String unaDire) {
		this.setDireccion(unaDire);
		this.setNombre(unNombre);
		this.setTelefono(unTel);
	}
	
	//getters & setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public Integer getTelefono() {return telefono;}
	public void setTelefono(Integer telefono) {this.telefono = telefono;}
	
	public String getDireccion() {return direccion;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	
	public Collection<ObraSocial> getObrasSociales() {return obrasSociales;}
	public void setObrasSociales(Collection<ObraSocial> obrasSociales) {this.obrasSociales = obrasSociales;}
	
	
	
}
