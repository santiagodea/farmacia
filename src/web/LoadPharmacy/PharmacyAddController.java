package web.LoadPharmacy;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;

public class PharmacyAddController implements Serializable{
	private static final long serialVersionUID = 607703913826297717L;
	
	protected String name;
	protected String address;
	protected Integer landphone;
	protected Integer alternativephone;
	
	protected List<SocialWork> socialWorkList; 
	
	
	public PharmacyAddController() {
	}
	public void SetPharmacy(Pharmacy pharmacy) {
		this.setAddress(pharmacy.getAddress());
		this.setAlternativephone(pharmacy.getAlternativePhone());
		this.setLandphone(pharmacy.getLandPhone());
		this.setName(pharmacy.getName());
		this.setSocialWorkList(pharmacy.getSocialWorks());
	}
	
	
	public List<String> nameSocialWorksList(){
		return this.getSocialWorkList().stream().map(s -> s.getName()).collect(Collectors.toList());
	}
	
	//setters & getters
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
	public Integer getAlternativephone() {
		return alternativephone;
	}
	public void setAlternativephone(Integer alternativephone) {
		this.alternativephone = alternativephone;
	}
	public List<SocialWork> getSocialWorkList() {
		return socialWorkList;
	}
	public void setSocialWorkList(List<SocialWork> socialWorkList) {
		this.socialWorkList = socialWorkList;
	}
	
}
