package web.SocialWorkLoad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;
import web.LoadPharmacy.CheckController;

public class SocialWorkController implements Serializable {
	private static final long serialVersionUID = -8975075892254966226L;

	private SocialWork socialWork;
	private PharmApp app;
	protected List<CheckController> checked = new ArrayList<>();

	
	public SocialWorkController(){
		this.socialWork = null;
		this.app = PharmApp.store();
	}
	
	//getters and setters
	public SocialWork getSocialWork(){return socialWork;}
	public void setSocialWork(SocialWork socialWork){this.socialWork = socialWork;}
	
	public List<SocialWork> socialWorkList(){
		return this.getApp().getSocialWorks();
	}
	
	public PharmApp getApp(){
		return app;
	}
	public void setApp(PharmApp app){
		this.app = app;
	}
	
	public void setChosenSocailWork(SocialWork theSocialWork) {
		checked.clear();
		this.pharmacyList().forEach(f -> checked.add((new ControllerCheck(f))));
		this.socialWork = theSocialWork;
	}
	public SocialWork getChosenSocialWork(){
		return socialWork;
	}
	public boolean hasChosenSocialWork(){ return this.socialWork != null;}
	
//	public List<SocialWork> getSocialWorkToShow(){
//		return this.getApp().socialWorkList();
//	}
	
	public List<Pharmacy> pharmacyList(){
		return this.getApp().pharmacyList().stream()
				.filter(f -> f.getSocialWorks().contains(this) )
				.collect(Collectors.toList());
	}	
}
