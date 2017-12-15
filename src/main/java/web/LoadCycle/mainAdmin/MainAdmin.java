package web.LoadCycle.mainAdmin;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.Sector;

public class MainAdmin extends WebPage {
	private static final long serialVersionUID = 2290852481068326561L;
	
	private ControllerMainAdmin controller;

	public MainAdmin(){
		super();
		this.controller = new ControllerMainAdmin();
		this.fillSector();
		this.add(new PanelCycle("cyclePanel", this.controller));
		this.add(new PanelException("exceptionPanel", this.controller));
	}

	
	public MainAdmin(ControllerMainAdmin controller2) {
		super();
		this.controller = controller2;
		this.fillSector();
		this.add(new PanelCycle("cyclePanel", this.controller));
		this.add(new PanelException("exceptionPanel", this.controller));
	}


	private void fillSector() {
		
		Form<Sector> form = new Form<Sector>("formSectorSelect"){
			private static final long serialVersionUID = 2586399264322332714L;
			
			@Override
			protected void onSubmit() {
				this.setResponsePage(MainAdmin.this);
			}
		};
		
		DropDownChoice<String> dropDown = new DropDownChoice<>("sector",
									 	 		 new PropertyModel<>(this.controller, "actualSector"),
												 new PropertyModel<>(this.controller, "sectorList"),
												 new ChoiceRenderer<>("name"));
		
		form.add(dropDown);
		this.add(form);
	}
	
}
