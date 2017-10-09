package modeloFarmacia;

import java.io.Serializable;

public class SocialWork extends InfoStandard implements Serializable{
	private static final long serialVersionUID = -4917617836746173247L;
	
	public SocialWork() {
		super();
	}
	
	public SocialWork(String name, String address, Integer landphone) {
		super(name, address, landphone);
	}


}
