package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PharmApp implements Serializable {
	private static final long serialVersionUID = 4606942675221926577L;

	private static PharmApp state;
	
	private List<Sector> sectorList = new ArrayList<>();
	private List<SpecialEvent> SpecialEventList = new ArrayList<>();
	
	private LocalDate date; //para test FECHA ACTUAL falsa
	
//constructor	
	private PharmApp() {
		//Sectores
		Sector norte = new Sector("NORTE",LocalDate.of(2016, 12, 31));

		sectorList.add(norte);
		//sectorList.add(new Sector("SUR",LocalDate.of(2016, 12, 31)));
		
		norte.createCycle(LocalDate.of(2017,12,31));
		
		//creo las farmacias
		Pharmacy farmacia1 = new Pharmacy("De Cicco", "Guemes 399", 452222, 452223);
		Pharmacy farmacia2 = new Pharmacy("Pasteur", "Calle 18 Nª300", 452254, 453333);

		//creo las obras sociales
		SocialWork obraS1 = new SocialWork("OSDE", "sarasa 1000", 456666);
		SocialWork obraS2 = new SocialWork("IOMA", "sarasa 1100", 455555);

		farmacia1.addSocialWork(obraS1);
		farmacia1.addSocialWork(obraS2);
		
		farmacia2.addSocialWork(obraS1);
		
		norte.addPharmacy(farmacia1);
		norte.addPharmacy(farmacia2);

	}
	
	//Singleton
	public static PharmApp store(){
		if(state == null){
			state = new PharmApp();
		}
		return state;
	}

	//
	public Sector getSectorCall(String sectorName) {
		return this.sectorList.stream().filter(s -> s.getName().equals(sectorName.toUpperCase())).findFirst().get();
	}
	//agrega una farmacia al secor
	public void addPharmacyToSector(Pharmacy farmacia, String sectorName) {
		
		
		if(this.canIaddPharmacy(farmacia)) {	
			this.getSectorCall(sectorName).addPharmacy(farmacia);
		}
		else {throw new RuntimeException("la farmacia ya esta en algun sector");
		}
	
	
	}
	//valida si puede agregar una determinada farmacia al sector
	public boolean canIaddPharmacy(Pharmacy farmacia){
		return this.getSectorList().stream().anyMatch(sector -> !sector.existPharmacy(farmacia));
	}
	
	
//getters y setters
	public LocalDate getDate() {
			// ESTO DEBE SER LocalDate.now();
			return date;
	}


	public List<Sector> getSectorList() {
			return sectorList;
	}

	public void addSpeciaEvent(SpecialEvent specialEvent) {
		this.getSpecialEventList().add(specialEvent);
	}
	
	public void setSectorList(List<Sector> sectorList) {
			this.sectorList = sectorList;
	}
	
//este no deberia existir solo para test
	public void setDate(LocalDate date) {
			this.date = date;
	}

	public List<SpecialEvent> getSpecialEventList() {
		return SpecialEventList;
	}

	public void setSpecialEventList(List<SpecialEvent> specialEventList) {
		SpecialEventList = specialEventList;
	}	
}
