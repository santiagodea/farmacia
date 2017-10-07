package web.LoadCycle.newCycle;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import web.LoadCycle.mainAdmin.MainAdmin;

public class CyclePanel extends Panel {
	private static final long serialVersionUID = -2202245295610876601L;
	//ATRIBUTOS
	private CycleController controllerC;
	//CONSTRUCTOR
	public CyclePanel(String id, CycleController controller) {
		super(id);
		this.controllerC = controller;
		this.controllerC.fillChecked();
		this.fillPanel();
		this.fillOkCancelButtons();

	}
	//METODOS
	protected void fillPanel() {
		CompoundPropertyModel<CycleController> controllerModel = new CompoundPropertyModel<>(this.controllerC);

		// fields
		this.add(new Label("start", controllerModel.bind("dateStart")));
		this.add(new TextField<>("end", controllerModel.bind("dateEndString")));

		ListView<CheckControllerPharmacy> listView = new ListView<CheckControllerPharmacy>("list",
				controllerC.getChecked()) {
			private static final long serialVersionUID = 863206267657440733L;

			protected void populateItem(ListItem<CheckControllerPharmacy> item) {
				CheckControllerPharmacy controller = item.getModelObject();
				item.add(new Label("name", controller.getName()));
				item.add(new CheckBox("check", new PropertyModel<>(controller, "checked")));
			}
		};
		listView.setReuseItems(true);
		add(listView);
		this.add(new Label("error", controllerModel.bind("ControllerErrorMsg")));
	}

	private void fillOkCancelButtons() {
		Link<String> cancelAction = new Link<String>("cancelAction") {
			private static final long serialVersionUID = 3251048626635072477L;

			@Override
			public void onClick() {
				this.setResponsePage(new MainAdmin());

			}
		};
		this.add(cancelAction);

	}

	// SETTERS & GETTERS
	public CycleController getControllerC() {
		return controllerC;
	}

	public void setControllerC(CycleController controllerC) {
		this.controllerC = controllerC;
	}
}