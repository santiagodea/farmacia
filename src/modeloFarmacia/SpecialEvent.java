package modeloFarmacia;

import java.time.LocalDate;

public class SpecialEvent {
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private String description;
	
	//constructor
	public SpecialEvent(String name, LocalDate dateStart, LocalDate dateEnd, String description) {
		this.setDateEnd(dateEnd);
		this.setDateStart(dateStart);
		this.setDescription(description);
		this.setName(name);
	}
	
	
	
	
	//setter y getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
