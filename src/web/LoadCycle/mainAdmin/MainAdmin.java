package web.LoadCycle.mainAdmin;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;

public class MainAdmin extends WebPage {
	private static final long serialVersionUID = 2290852481068326561L;
	
	private ControllerMainAdmin controller;

	public MainAdmin(){
		super();
		this.controller = new ControllerMainAdmin();
		this.fillSector();
		this.add(new PanelCycle("cyclePanel", this.controller));
	}

	
	private void fillSector() {
		DropDownChoice<String> dropDown = new DropDownChoice<>("sector",
									 	 		 new PropertyModel<>(this.controller, "actualSector"),
												 new PropertyModel<>(this.controller, "sectorList"),
												 new ChoiceRenderer<>("name"));
		this.add(dropDown);
	}
	
}
