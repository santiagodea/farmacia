package web.SocialWorkLoad;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;

public class SocialWorkAddController implements Serializable {
	private static final long serialVersionUID = -3435926805115371042L;

	//ATRIBUTOS
		protected String name;
		protected String address;
		protected Integer landphone;
		protected List<Pharmacy> pharmacysList;
		
		//CONSTRUCTOR
		public SocialWorkAddController() {
		}

		public void SetSocialWork(SocialWork socialWork) {
			this.setAddress(socialWork.getAddress());
			this.setLandphone(socialWork.getLandPhone());
			this.setName(socialWork.getName());
		}
		
		//METODOS
		public List<String> pharmacysListName() {
			return PharmApp.store().pharmacyList().stream().map(f -> f.getName()).collect(Collectors.toList());
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

	

		public List<Pharmacy> getpharmacysList() {
			return pharmacysList;
		}

		public void setSocialWorkList(List<Pharmacy> pharmacysList) {
			this.pharmacysList = pharmacysList;
		}
	
}
