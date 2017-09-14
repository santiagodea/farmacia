package modeloFarmacia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PharmApp {
	private static PharmApp state;
	
	private List<Sector> sectorList = new ArrayList<>();
	
	private LocalDateTime date; //para test FECHA ACTUAL falsa
	
//constructor	
	private PharmApp() {
		//Sectores
		sectorList.add(new Sector("NORTE"));
		sectorList.add(new Sector("SUR"));
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
		this.getSectorCall(sectorName).addPharmacy(farmacia);
	}
	//valida si puede agregar una determinada farmacia al sector
	public boolean canIaddPharmacy(Pharmacy farmacia){
		return !this.getSectorList().stream().anyMatch(sector -> sector.existPharmacy(farmacia));
	}
	
	
//getters y setters
	public LocalDateTime getDate() {
			// ESTO DEBE SER LocalDateTime.now();
			return date;
	}


	public List<Sector> getSectorList() {
			return sectorList;
	}


	public void setSectorList(List<Sector> sectorList) {
			sectorList = sectorList;
	}
//este no deberia existir solo para test
	public void setDate(LocalDateTime date) {
			this.date = date;
	}	
}
