package modeloFarmacia;

import java.util.ArrayList;
import java.util.Collection;

public class Pharmacy extends InfoStandard{
	private Collection<SocialWork> socialWorks = new ArrayList<>();
	
	//constructor
	public Pharmacy(String name,String address, int landphone, int alternativePhone) {
		super(name, address , landphone, alternativePhone);
	}
	
	//getters & setters

	public Collection<SocialWork> getSocialWorks() {return socialWorks;}
	public void setSocialWorks(Collection<SocialWork> obrasSociales) {this.socialWorks = obrasSociales;}
	

	public boolean cantAddISocialWork(SocialWork socialWork) {
		return (!this.getSocialWorks().contains(socialWork));
	}
	public void addSocialWork(SocialWork socialWork) {
		this.getSocialWorks().add(socialWork);
	}
	
	
}
