package web.SocialWorkLoad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;
import web.LoadPharmacy.CheckController;

public class SocialWorkEditionController implements Serializable  {
	private static final long serialVersionUID = 8530329019166862626L;

	// ATRIBUTOS
		protected String name;
		protected String address;
		protected Integer landphone;
		protected List<Pharmacy> pharmacys;
		protected List<ControllerCheck> checked = new ArrayList<>();

		// CONSTRUCTOR
		public SocialWorkEditionController() {
		}

		// METODOS
		public void setSocialWorkToBeUpdated(SocialWork socialWork) {
			this.setName(socialWork.getName());
			this.setAddress(socialWork.getAddress());
			this.setLandphone(socialWork.getLandPhone());
		}

		public List<Pharmacy> getPharmacys() {
			return PharmApp.store().pharmacyList();
		}

		public void accept() {
			SocialWork newSocialWork = this.buildSocialWork();
			
		}

		public SocialWork buildSocialWork() {
			return new SocialWork(this.getName(), this.getAddress(), this.getLandphone());
		}



		// SETTERS & GETTERS
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getLandphone() {
			return landphone;
		}

		public void setLandphone(Integer landphone) {
			this.landphone = landphone;
		}

		public void setPharmacys(List<Pharmacy> pharmacys) {
			this.pharmacys = pharmacys;
		}

}
