package web.LoadCycle.mainAdmin;

import java.io.Serializable;
import java.util.List;

import modeloFarmacia.Cycle;
import modeloFarmacia.PharmApp;
import modeloFarmacia.Sector;

public class ControllerMainAdmin  implements Serializable{
	private static final long serialVersionUID = 3583465022871249000L;
	
	Sector actualSector;

	public List<Sector> getSectorList(){
		return PharmApp.store().getSectorList();
	}
	
	public List<Cycle> getCycles(){
		if (this.actualSector != null){
			return this.getActualSector().getCycles();
		} else {
			return null;
		}
	}
	
//Getters y Setters
	
	public Sector getActualSector(){
		return this.actualSector;
	}
	public void setActualSector(Sector actualSector){
		this.actualSector = actualSector;
		System.out.println("setie el sector");
	}

	public boolean hasSectorSelected() {
		return this.getActualSector() != null;
	}
}
