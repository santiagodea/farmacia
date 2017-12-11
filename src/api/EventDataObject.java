package api;

import modeloFarmacia.SpecialEvent;

public class EventDataObject {
	//Constructors

	public EventDataObject(SpecialEvent event){
		this.description = event.getDescription();
		this.name = event.getName();
		this.title = event.getTitle();
	}
	
	//Fields

	String description;
	String name;
	String title;
	
	//Methods

	
	//Getters y Setters

	public String getDescription(){
		return this.description;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getTitle(){
		return this.title;
	}
}
