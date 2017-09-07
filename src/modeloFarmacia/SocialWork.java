package modeloFarmacia;

import java.util.ArrayList;
import java.util.List;

public class SocialWork extends InfoStandard{
	private List<Pharmacy> pharmacyList = new ArrayList<Pharmacy>(); 

	public SocialWork(String name, String address, int landphone) {
		super(name, address, landphone);
	}

	
	
	
	//getters & setters
	
	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}

	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}
	
	
}
