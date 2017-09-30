package web.LoadCycle.mainAdmin;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.Cycle;

public class PanelCycle extends Panel {
	private static final long serialVersionUID = -6914789013649545486L;

	private ControllerMainAdmin controller;
	
	public PanelCycle(String id, ControllerMainAdmin controller) {
		super(id);
		this.setController(controller);
		this.fillCycleList();
	}
	

	private void fillCycleList() {
		ListView<Cycle> listV = new ListView<Cycle>("cycles", new PropertyModel<>(this.controller, "cycles")) {
			private static final long serialVersionUID = -8567160815495998000L;

	
			@Override
			protected void populateItem(ListItem<Cycle> panel) {
				Cycle actualCycle = panel.getModelObject();
				CompoundPropertyModel<Cycle> comp = new CompoundPropertyModel<>(actualCycle);

				panel.add(new Label("since", comp.bind("dateStart")));
				panel.add(new Label("until", comp.bind("dateEnd")));
				
				//TODO boton para editar??? en el ultimo
			}
		};
		this.add(listV);
	}


	@Override
	public boolean isVisible() {
		return super.isVisible() && this.getController().hasSectorSelected();
	}

//Setters y Getters
	public ControllerMainAdmin getController() {
		return controller;
	}


	public void setController(ControllerMainAdmin controller) {
		this.controller = controller;
	}
	
}
