package web.SocialWorkLoad;

import java.io.Serializable;

import modeloFarmacia.Pharmacy;


public class ControllerCheck implements Serializable {
	private static final long serialVersionUID = -5889760295180110035L;
	

	
	private Pharmacy pharmacy;
	private Boolean checked;
	
	public ControllerCheck(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
		this.checked = false;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getName() {
		return this.getPharmacy().getName();
	}

	
}