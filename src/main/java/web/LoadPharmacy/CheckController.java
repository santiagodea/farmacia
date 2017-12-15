package web.LoadPharmacy;

import java.io.Serializable;

import modeloFarmacia.SocialWork;

public class CheckController implements Serializable {
	private static final long serialVersionUID = -7417135472975785932L;
	
	//ATRIBUTOS
	private SocialWork socialwork;
	private Boolean checked;
	//CONSTRUCTORS
	public CheckController(SocialWork social) {
		socialwork = social;
		checked = false;
	}

	// SETTERS & GETTERS
	public SocialWork getSocialwork() {
		return socialwork;
	}

	public void setSocialwork(SocialWork socialwork) {
		this.socialwork = socialwork;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getName() {
		return this.getSocialwork().getName();
	}

}
