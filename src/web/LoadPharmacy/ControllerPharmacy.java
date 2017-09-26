package web.LoadPharmacy;

import java.io.Serializable;
import java.util.List;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;

public class ControllerPharmacy implements Serializable{
	private static final long serialVersionUID = 7999909257917603937L;
	
	private Pharmacy pharmacy;
	private PharmApp app;	
	//constructor
	public ControllerPharmacy() {
		this.pharmacy = null;
		this.app = PharmApp.store();
	}
	

	//getters & setters
	public Pharmacy getPharmacy() {return pharmacy;}
	public void setPharmacy(Pharmacy pharmacy) {this.pharmacy = pharmacy;}

	public List<Pharmacy> pharmacyList(){
		return this.getApp().pharmacyList();
	}

	public PharmApp getApp() {
		return app;
	}
	public void setApp(PharmApp app) {
		this.app = app;
	}
	
	public void setChosenPharmacy(Pharmacy pharmacy) { 
		this.pharmacy = pharmacy;
	}
	public Pharmacy getChosenPharmacy() { 
		return pharmacy;
	}
	
	public boolean hasChosenPharmacy() { return this.pharmacy != null; }
	
	public List<Pharmacy> getAlbumsToShow() {
		return this.getApp().pharmacyList();
	}
	
	
}
