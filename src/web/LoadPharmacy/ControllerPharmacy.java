package web.LoadPharmacy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import web.LoadCycle.mainAdmin.Controller;

public class ControllerPharmacy extends Controller implements Serializable{
	private static final long serialVersionUID = 7999909257917603937L;
	
	private Pharmacy pharmacy;
	private PharmApp app;	
	protected List<CheckController> checked = new ArrayList<>();
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
		checked.clear();
		pharmacy.getSocialWorks().forEach(s -> checked.add(new CheckController(s)));
		this.pharmacy = pharmacy;
		
	}
	public Pharmacy getChosenPharmacy() { 
		return pharmacy;
	}
	
	public boolean hasChosenPharmacy() { return this.pharmacy != null; }
	
	public List<Pharmacy> getAlbumsToShow() {
		return this.getApp().pharmacyList();
	}
	
	public List<String> socialWorksListName(){
		if (this.getPharmacy().getSocialWorks().stream().map(s -> s.getAddress()).collect(Collectors.toList()) == null) {
			return (new ArrayList<>(Arrays.asList("")));
		}
		else {
			return this.getPharmacy().getSocialWorks().stream().map(s -> s.getAddress()).collect(Collectors.toList());
		}	
	}
}
