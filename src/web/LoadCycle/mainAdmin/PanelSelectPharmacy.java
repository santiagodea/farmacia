package web.LoadCycle.mainAdmin;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class PanelSelectPharmacy extends Panel {
	private static final long serialVersionUID = 1799196216533792082L;

	private ControllerMainAdmin controller;

//Constructor
	
	public PanelSelectPharmacy(String id,ControllerMainAdmin controller) {
		super(id);
		this.setController(controller);
		this.fillExceptionPharmacy();
	}

	
//Methods
	
	private void fillExceptionPharmacy() {
		Form<ControllerMainAdmin> formPharmacy = new Form<ControllerMainAdmin>("exceptionFormPharmacy"){
			private static final long serialVersionUID = 2586399264322332714L;
			
			@Override
			protected void onSubmit() {
				PanelSelectPharmacy.this.controller.saveException();
				//TODO mejorar esto aca deberia mandar main admin con un conrtoller que posea el sector seleccionado
				ControllerMainAdmin newcontroller = new ControllerMainAdmin();
				newcontroller.setActualSector(PanelSelectPharmacy.this.controller.getActualSector());
				this.setResponsePage(new MainAdmin(newcontroller));
			}
		};
		
		DropDownChoice<String> dropDown = new DropDownChoice<>("pharmacy",
									 	 		 new PropertyModel<>(this.getController(), "actualPharmacyException"),
												 new PropertyModel<>(this.getController(), "pharmacyCycleList"),
												 new ChoiceRenderer<>("name"));
		
		formPharmacy.add(dropDown);
		this.add(formPharmacy);
	}

	public ControllerMainAdmin getController() {
		return controller;
	}

	public void setController(ControllerMainAdmin controller) {
		this.controller = controller;
	}

	
	@Override
	public boolean isVisible() {
		return super.isVisible() && this.controller.hasDateExceptionSelect() && !this.controller.errorPresent();
	}

}
