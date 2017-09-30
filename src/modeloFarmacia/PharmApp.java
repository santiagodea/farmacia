package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PharmApp implements Serializable {
	private static final long serialVersionUID = 4606942675221926577L;

	private static PharmApp state;
	
	private List<Sector> sectorList = new ArrayList<>();
	private List<SpecialEvent> SpecialEventList = new ArrayList<>();
	
	private List<SocialWork> socialWorks = new ArrayList<>();
	
	private LocalDate date; //para test FECHA ACTUAL falsa
	
//constructor	
	private PharmApp() {
		//Sectores
		Sector norte = new Sector("NORTE",LocalDate.of(2016, 12, 31));
		Sector sur = new Sector("SUR",LocalDate.of(2016, 12, 31));
			
		sectorList.add(norte);
		sectorList.add(sur);

		norte.createCycle(LocalDate.of(2017,12,31));

		sur.createCycle(LocalDate.of(2017,12,31));
		sur.createCycle(LocalDate.of(2018,12,31));
		
		//creo las farmacias
		Pharmacy belgrano = new Pharmacy("Belgrano", "Rivadavia y Av. San Martin", 454064, 450000);
		Pharmacy callegari = new Pharmacy("Callegari", "De La Fuente y Paso", 452861, 450000);
		Pharmacy decicco = new Pharmacy("De Cicco", "Guemes y Soloeta", 453064, 450000);
		Pharmacy dimatteo = new Pharmacy("Di Matteo", "Dr. Torras y Moreno", 452088, 450000);
		Pharmacy garcia = new Pharmacy("Garcia", "Dr Ortiz Nro 34", 454263, 453333);

		
		//Creo los eventos especiales
		this.addSpeciaEvent(new SpecialEvent(	"Chancho Movil",
												"Chancho Movil - Club Belgrano",
												LocalDate.of(2017,3,10),
												LocalDate.of(2017,3,15),
												"Estamos en la plaza todas las tardes, vendiendo el habitual chanchomovil, "));
		
		this.addSpeciaEvent(new SpecialEvent("CINE",
										"Nueva Pelicula - IT",
										LocalDate.of(2017,3,16),
										LocalDate.of(2017,3, 23),
										"Se estará estrenando IT - el payaso asesino, toda esta semana en cartelera"));
		
		this.addSpeciaEvent(new SpecialEvent("Casa de campo",
				"INFO - Jejenes",
				LocalDate.of(2017,3,16),
				LocalDate.of(2017,3, 30),
				"Casa de campo informa que hoy y hasta el dia 30 se estará fumigando contra los Jejenes."));

		
		//creo las obras sociales
		SocialWork obraS1 = new SocialWork("OSDE", "sarasa 1000", 456666);
		SocialWork obraS2 = new SocialWork("IOMA", "sarasa 1100", 455555);
		
		this.getSocialWorks().add(obraS1);
		this.getSocialWorks().add(obraS2);


		belgrano.addSocialWork(obraS1);
		belgrano.addSocialWork(obraS2);
		
		callegari.addSocialWork(obraS1);
		
		norte.addPharmacy(belgrano);
		norte.addPharmacy(callegari);
		norte.addPharmacy(decicco);
		
		sur.addPharmacy(dimatteo);
		sur.addPharmacy(garcia);

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
	
	public List<Pharmacy> pharmacyList(){
		return this.getSectorList().stream().map(s -> s.getPharmacyList()).flatMap(l -> l.stream()).collect(Collectors.toList());
	}
	
	public void addSpecialEvent(SpecialEvent se){
			this.getSpecialEventList().add(se);
	}
	
//getters y setters
	public LocalDate getDate() {
			//TODO ESTO DEBE SER LocalDate.now();
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

	public List<SocialWork> getSocialWorks() {
		return socialWorks;
	}

	public void setSocialWorks(List<SocialWork> socialWorks) {
		this.socialWorks = socialWorks;
	}

	public List<SpecialEvent> getSpecialEventListTo(LocalDate date2) {
		return this.getSpecialEventList().stream()
				.filter(se -> se.includeDate(date2))
				.collect(Collectors.toList());
	}	
}
