package modeloFarmacia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PharmApp {
	private static PharmApp state;
	
	private List<Sector> sectorList = new ArrayList<>();
	private List<SpecialEvent> SpecialEventList = new ArrayList<>();
	
	private LocalDateTime date; //para test FECHA ACTUAL falsa
	
//constructor	
	private PharmApp() {
		//Sectores
		sectorList.add(new Sector("NORTE",LocalDate.of(2016, 12, 31)));
		sectorList.add(new Sector("SUR",LocalDate.of(2016, 12, 31)));
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
	public LocalDateTime getDate() {
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
	public void setDate(LocalDateTime date) {
			this.date = date;
	}

	public List<SpecialEvent> getSpecialEventList() {
		return SpecialEventList;
	}

	public void setSpecialEventList(List<SpecialEvent> specialEventList) {
		SpecialEventList = specialEventList;
	}	
}
