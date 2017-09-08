package modeloFarmacia;

public abstract class InfoStandard {

	private String name;
	private String address;
	private int landphone;
	private int alternativePhone;

	
//constructors
	public InfoStandard(String name, String address, int landphone) {
		this.setName(name);
		this.setAddress(address);
		this.setLandPhone(landphone);
	}
	
	public InfoStandard(String name, String address, int landphone, int alternativePhone) {
		this.setName(name);
		this.setAddress(address);
		this.setLandPhone(landphone);
		this.setAlternativePhone(alternativePhone);
	}


//getter y setters
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

	public int getLandPhone() {
		return landphone;
	}

	public void setLandPhone(int tel) {
		this.landphone = tel;
	}

	public int getAlternativePhone() {
		return alternativePhone;
	}

	public void setAlternativePhone(int alternativePhone) {
		this.alternativePhone = alternativePhone;
	}

	public boolean equals(InfoStandard info) {
		return this.getName().equals(info.getName());
	} 
	
	@Override
	public boolean equals(Object obj) {
		if(InfoStandard.class.isInstance(obj)){
			InfoStandard temp = (InfoStandard) obj;
			if(this.getName().equals(temp.getName())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}	
	}
}
