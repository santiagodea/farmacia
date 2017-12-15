package api;

import modeloFarmacia.Pharmacy;

public class PharmacyDataObject {

	/*
	 * Paso 2: armar el DataObject, la misma idea que lo que hicimos con los
	 * DataProvider en Android. Creo que la herramienta mira los atributos, con lo
	 * cual ni siquiera harían falta los getter.
	 */

	private String name;
	private String address;
	private Integer landphone;
	private Integer alternativePhone;

	// para comodidad, le puse un constructor que toma el "objeto inteligente"
	// como parámetro y lo destripa
	public PharmacyDataObject(Pharmacy pharmacy) {
		super();
		this.name = pharmacy.getName();
		this.address = pharmacy.getAddress();
		this.landphone = pharmacy.getLandPhone();
		this.alternativePhone = pharmacy.getAlternativePhone();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getLandphone() {
		return landphone;
	}

	public Integer getAlternativePhone() {
		return alternativePhone;
	}

}