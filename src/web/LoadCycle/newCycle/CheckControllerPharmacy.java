package web.LoadCycle.newCycle;

import modeloFarmacia.Pharmacy;

public class CheckControllerPharmacy {

	private Boolean checked;
	
	private Pharmacy pharmacy;
	
	public CheckControllerPharmacy(Pharmacy thePharmacy) {
		this.setPharmacy(thePharmacy);
		this.setChecked(true);
	}


	public String getName() {
		return this.getPharmacy().getName();
	}

	//getter and setterss
	public Boolean getChecked() {
		return checked;
	}


	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	public Pharmacy getPharmacy() {
		return pharmacy;
	}


	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}



	
	
	
}

