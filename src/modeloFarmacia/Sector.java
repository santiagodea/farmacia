package modeloFarmacia;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	private String name;
	private List<Pharmacy> pharmacyList = new ArrayList<>();
	public String getName() {
		return name;
	}
	
	//constructor
	public Sector (String name) {
		this.setName(name);
	}
	
	
	
	
	//setter y getters
	public void setName(String name) {
		this.name = name;
	}
	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}
	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}
	
	
}
