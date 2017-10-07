package modeloFarmacia;

public abstract class InfoStandard {

	private String name;
	private String address;
	private Integer landphone;
	private Integer alternativePhone;

	
//constructors
	public InfoStandard() {
		
	}
	
	public InfoStandard(String name, String address, Integer landphone) {
		this.setName(name);
		this.setAddress(address);
		this.setLandPhone(landphone);
	}
	
	public InfoStandard(String name, String address, Integer landphone, Integer alternativePhone) {
		this.setName(name);
		this.setAddress(address);
		this.setLandPhone(landphone);
		this.setAlternativePhone(alternativePhone);
	}

// metodos
	public boolean equals(InfoStandard info) {
		return this.getName().equals(info.getName());
	} 

// se redefinio el equals para poder comparar por el nombre de la misma y no poder crear mas de una farmacia con el mismo nombre
	@Override
	public boolean equals(Object obj) {
		if(InfoStandard.class.isInstance(obj)){
			InfoStandard temp = (InfoStandard) obj;
			if(this.getName().toUpperCase().equals(temp.getName().toUpperCase())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}	
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

	public Integer getLandPhone() {
		return landphone;
	}

	public void setLandPhone(Integer tel) {
		this.landphone = tel;
	}

	public Integer getAlternativePhone() {
		return alternativePhone;		
	}

	public void setAlternativePhone(Integer alternativePhone) {
		this.alternativePhone = alternativePhone;
	}
}