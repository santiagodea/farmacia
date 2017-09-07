package modeloFarmacia;

import java.time.LocalDateTime;

public class SpecialEvent {
	private String name;
	private LocalDateTime dateStart;
	private LocalDateTime dateEnd;
	private String description;
	
	//constructor
	public SpecialEvent(String name, LocalDateTime dateStart, LocalDateTime dateEnd, String description) {
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
	public LocalDateTime getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
