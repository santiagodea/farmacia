package modeloFarmacia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sector {
	private String name;
	private List<Pharmacy> pharmacyList = new ArrayList<>();
	private List<Cycle> cycles = new ArrayList<>();
	private LocalDate nextDayStartDate;
	
//constructor
	public Sector (String name, LocalDate date) {
		this.setName(name);
		this.nextDayStartDate = date;
	}

//methods
		
	

	public boolean existPharmacy(Pharmacy farmacia) {
		return this.getPharmacyList().contains(farmacia);
	}
	

	public void createCycle(LocalDate cycleEndDate) {
		this.getCycles().add(new Cycle(getNextDayStartDate().plusDays(1), cycleEndDate));
		this.setNextDayStartDate(cycleEndDate);
	}
	
	// agrega una farmacia al sector, si puede.
	public void addPharmacy(Pharmacy pharmacy) {
		if (this.candIaddSector(pharmacy)) {
			this.getPharmacyList().add(pharmacy);
		}
		else {
			 throw new RuntimeException("La farmacia " + pharmacy.getName() + " ya existe en el sector");
		}
	}

	private boolean candIaddSector(Pharmacy pharmacy) {
		// compara si la farmacia ya esta o no en la lista de farmacias en el sector
		return !this.getPharmacyList().contains(pharmacy);
	}

	public Pharmacy getShiftPharmacy(LocalDate actualDate) {
		Cycle findedCycle = this.findCycleWhithDate(actualDate);
		return findedCycle.getShiftPharmacy(this.getPharmacyList(), actualDate);
	}
	
	
	
	private Cycle findCycleWhithDate(LocalDate actualDate) {
		return	this.getCycles().stream().filter(c -> c.includeDate(actualDate)).findAny().get();
	}


//setter y getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}
	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}

	public List<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}


	public LocalDate getNextDayStartDate() {
		return nextDayStartDate;
	}

	public void setNextDayStartDate(LocalDate nextDayStartDate) {
		this.nextDayStartDate = nextDayStartDate;
	}


}
