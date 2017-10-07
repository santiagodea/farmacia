package modeloFarmacia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pharmacy extends InfoStandard implements Serializable{
	private static final long serialVersionUID = 3875238602213251423L;
	private List<SocialWork> socialWorks = new ArrayList<>();

	//constructor
	public Pharmacy() {
		super();
	}
	public Pharmacy(String name,String address, Integer landphone, Integer alternativePhone) {
		super(name, address , landphone, alternativePhone);
	}
	
	public boolean canIAddSocialWork(SocialWork socialWork) {
		return (!this.getSocialWorks().contains(socialWork));
	}
	public void addSocialWork(SocialWork socialWork) {
		if (this.canIAddSocialWork(socialWork)) {
			this.getSocialWorks().add(socialWork);
		}
		else {throw new RuntimeException("la farmacia ya tiene la obra social " +  socialWork);}
	}	
	
	//getters & setters
	public List<SocialWork> getSocialWorks() {return socialWorks;}
	public void setSocialWorks(List<SocialWork> obrasSociales) {this.socialWorks = obrasSociales;}

}
