package api;

import java.time.LocalDate;
import java.util.List;

public class IndexDataObject {

	//Constructors

	public IndexDataObject(LocalDate date, List<PharmacyDataObject> shiftPharmacys, List<EventDataObject> eventData) {
		this.date = date;
		this.shiftPharmacys = shiftPharmacys;
		this.eventData = eventData;
	}

	//Fields
	
	private LocalDate date;
	private List<PharmacyDataObject> shiftPharmacys;
	private List<EventDataObject> eventData;


	//Methods

	//Getters y Setters
	
	public LocalDate getDate() {
		return date;
	}
	public List<PharmacyDataObject> getShiftPharmacys() {
		return shiftPharmacys;
	}
	public List<EventDataObject> getEventData() {
		return eventData;
	}
	
}
