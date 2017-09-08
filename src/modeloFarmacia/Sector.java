package modeloFarmacia;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	private String name;
	private List<Pharmacy> pharmacyList = new ArrayList<>();
	private List<Cycle> cycles = new ArrayList<>();

	
//constructor
	public Sector (String name) {
		this.setName(name);
	}
	
	
//methods
	
	
	public boolean canIaddCycle(Cycle cicle){
		//TODO aca deberia verificar que no se solape con otro ciclo
		return true;
	}
	
//setter y getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}
	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}

	public void addPharmacy(Pharmacy farmacia) {
		this.getPharmacyList().add(farmacia);
	}


	
	public void addCycle(Cycle cicle) {
		this.getCycles().add(cicle);
	}

	public List<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}

	public boolean existPharmacy(Pharmacy farmacia) {
		return this.getPharmacyList().contains(farmacia);
	}


	
}
