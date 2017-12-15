package modeloFarmacia;

import java.io.Serializable;
import java.time.LocalDate;

public class SpecialEvent implements Serializable{
	private static final long serialVersionUID = 7429464403569611411L;
	private String name;
	private String title;
	private String description;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	
	//constructor
	public SpecialEvent(String name, String title, LocalDate dateStart, LocalDate dateEnd, String description) {
		this.setDateEnd(dateEnd);
		this.setDateStart(dateStart);
		this.setDescription(description);
		this.setName(name);
		this.setTitle(title);
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public boolean includeDate(LocalDate date) {
		return  (this.getDateStart().isBefore(date) ||this.getDateStart().isEqual(date))  && 
				(this.getDateEnd().isAfter(date) || this.getDateEnd().isEqual(date));
	}	
}
