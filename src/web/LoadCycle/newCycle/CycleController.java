package web.LoadCycle.newCycle;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modeloFarmacia.Cycle;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.Sector;
import web.LoadCycle.mainAdmin.Controller;

public class CycleController extends Controller implements Serializable {
	private static final long serialVersionUID = 3940621338505746999L;

	// ATRIBUTOS
	private LocalDate dateStart; // automaticamente al crearlo se asigna la fecha siguiente al ultimo siglo
									// vigente
	private LocalDate dateEnd;
	private String dateEndString;
	private List<Pharmacy> pharmacyList = new ArrayList<>();
	private List<CheckControllerPharmacy> checked = new ArrayList<>();
	private Sector sector;

	// CONSTRUCTOR
	public CycleController(Sector aSector) {
		this.setSector(aSector);
		this.setPharmacyList(aSector.getPharmacyList());
		this.setDateStart(getDateEndCycle());
	}

	private LocalDate getDateEndCycle() {
		return getSector().getCycles().get(getSector().getCycles().size() - 1).getDateEnd().plusDays(1);
	}

	public void fillChecked() {
		this.getPharmacyList().forEach(p -> this.getChecked().add(new CheckControllerPharmacy(p)));
	}

	public void setCycleToBeUpdated(Cycle cycle) {
		this.setDateEnd(cycle.getDateEnd());
		this.setPharmacyList(cycle.getPharmacysInCycle());
	}

	public void accept() {
		Cycle newCycle = this.buildCycle();
		newCycle.setPharmacysInCycle(checked.stream().filter(c -> c.getChecked().equals(true)).map(c -> c.getPharmacy())
				.collect(Collectors.toList()));
		this.validate();
		sector.getCycles().add(newCycle);

	}

	public void validate() {
		if (this.getDateEnd() == null) {
			throw new RuntimeException("Inserte una fecha valida formato: AAAA-MM-DD");
		}
	}

	public Cycle buildCycle() {
		Cycle newCycle = new Cycle(getDateStart(), getDateEnd(), this.sector);
		newCycle.setPharmacysInCycle(getPharmacyList());
		return newCycle;
	}

	public void setDateEndString(String dateEndString) {

		this.setControllerErrorMsg("");
		try {
			LocalDate ld = LocalDate.parse(dateEndString);
		} catch (DateTimeParseException e) {
			this.setControllerErrorMsg("Inserte una fecha valida formato: AAAA-MM-DD");
		} catch (java.lang.Exception e) {
			this.setControllerErrorMsg(e.getMessage());
		}
		this.dateEndString = dateEndString;
	}

	// GETTERS & SETTERS
	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public List<Pharmacy> getPharmacyList() {
		return pharmacyList;
	}

	public void setPharmacyList(List<Pharmacy> pharmacyList) {
		this.pharmacyList = pharmacyList;
	}

	public List<CheckControllerPharmacy> getChecked() {
		return checked;
	}

	public void setChecked(List<CheckControllerPharmacy> checked) {
		this.checked = checked;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getDateEndString() {
		return dateEndString;
	}
}