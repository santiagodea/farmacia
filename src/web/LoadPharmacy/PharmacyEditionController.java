package web.LoadPharmacy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;
import modeloFarmacia.SocialWork;

public class PharmacyEditionController implements Serializable{
	private static final long serialVersionUID = -4884554301237313447L;
	
	protected String name;
	protected String address;
	protected Integer landphone;
	protected Integer alternativePhone;
	protected List<SocialWork> socialWorks;
	protected Sector sector;
	protected List<Sector> sectorList;
	
	protected List<CheckController> checked = new ArrayList<>();
	
	public PharmacyEditionController() { 
		}
		
		public void setBandToBeUpdated(Pharmacy pharmacy) {
			this.setName(pharmacy.getName());
			this.setAddress(pharmacy.getAddress());
			this.setAlternativePhone(pharmacy.getAlternativePhone());
			this.setLandphone(pharmacy.getLandPhone());
			this.setSectorList(PharmApp.store().getSectorList());
			
		}

		//getters and setters
		
		public List<SocialWork> getSocialWorks() {
			return PharmApp.store().getSocialWorks();
		}
		
		public void accept() {
			Pharmacy newPharmacy = this.buildPharmacy();
			newPharmacy.addSocialWork(new SocialWork("afas", "calle olvidada", 25252559));
			newPharmacy.setSocialWorks(checked.stream().filter(c -> c.getChecked().equals(true)).map(c -> c.getSocialwork()).collect(Collectors.toList()));
			
			
			PharmApp.store().addPharmacyToSector(newPharmacy,"norte");

		}
		
		public Pharmacy buildPharmacy() {
			return new Pharmacy(this.getName(), this.getAddress(), this.getLandphone(), this.getAlternativePhone());
			
			
			
		}
		
		public List<Sector> getSectorToShow() {
			return PharmApp.store().getSectorList();
		}
		
		
		
		// getters and setters
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

		public Integer getAlternativePhone() {
			return alternativePhone;
		}

		public void setAlternativePhone(Integer alternativePhone) {
			this.alternativePhone = alternativePhone;
		}


		public Sector getSector() {
			return sector;
		}

		public void setSector(Sector sector) {
			this.sector = sector;
		}

		public List<Sector> getSectorList() {
			return sectorList;
		}

		public void setSectorList(List<Sector> sectorList) {
			this.sectorList = sectorList;
		}

		public void setSocialWorks(List<SocialWork> socialWorks) {
			this.socialWorks = socialWorks;
		}

			
}