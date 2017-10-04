package web.LoadCycle.mainAdmin;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;



public class PanelException extends Panel {
	private static final long serialVersionUID = -4187676151137847460L;
	protected ControllerMainAdmin controller;

//Constructors
	
	public PanelException(String id, ControllerMainAdmin controller ) {
		super(id);
		this.controller = controller;
		this.fillExceptionDate();
		this.fillListExceptions();
		this.add(new PanelSelectPharmacy("pharmacySelect", controller));
	}

//Methods
	
	
	private void fillListExceptions() {
		ListView<modeloFarmacia.Exception> listV = new ListView<modeloFarmacia.Exception>("exceptions", new PropertyModel<>(this.controller, "exceptions")) {
			private static final long serialVersionUID = -8567160815495988000L;
	
	
			@Override
			protected void populateItem(ListItem<modeloFarmacia.Exception> panel) {
				modeloFarmacia.Exception actualException = panel.getModelObject();
				CompoundPropertyModel<modeloFarmacia.Exception> comp = new CompoundPropertyModel<>(actualException);
	
				//TODO calculo de remplazada en el modelo
				panel.add(new Label("remplaced", comp.bind("pharmacyCalculatedReplaced.name")));
				panel.add(new Label("remplace", comp.bind("pharmacy.name")));
				panel.add(new Label("date", comp.bind("date")));
			}
		};
		this.add(listV);
	}



	private void fillExceptionDate() {
		
		Form<ControllerMainAdmin> form = new Form<ControllerMainAdmin>("exceptionFormDate"){
			private static final long serialVersionUID = 2586399264322332714L;
			
			@Override
			protected void onSubmit() {
				this.setResponsePage(new MainAdmin(PanelException.this.controller));
			}
		};

		form.add(new TextField<>("dateException",new PropertyModel<>(this.controller, "dateExceptionString")));
		
		this.add(form);
	}


	
	@Override
	public boolean isVisible() {
		return super.isVisible() && this.controller.hasSectorSelected();
	}
}
