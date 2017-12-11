package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import modeloFarmacia.SocialWork;

public class SocialWorkDataObject {
	
	private SocialWork socialWork;
	private List<PharmacyDataObject> pharmacys = new ArrayList<>();


	public SocialWorkDataObject(SocialWork sw,List<PharmacyDataObject> phars ){
		this.pharmacys = phars;
		this.socialWork = sw;
	}
	
}
