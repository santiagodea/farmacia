package web.LoadPharmacy;




import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.PharmApp;
import modeloFarmacia.SocialWork;

public class PharmacyEditionPanel extends Panel{
	private static final long serialVersionUID = 2451481869719251482L;

	protected PharmacyEditionController controller;
	protected List<SocialWork> theSocials = PharmApp.store().getSocialWorks();
	

	
	public PharmacyEditionPanel(String id, PharmacyEditionController _controller) {
		super(id);
		this.controller = _controller;
		this.fillChecked();
		this.fillPanel();
		this.fillOkCancelButtons();


	}

	private void fillChecked() {
		theSocials.forEach(s -> controller.checked.add(new CheckController(s, false)));	
	}


	protected void fillPanel() {
		CompoundPropertyModel<PharmacyEditionController> controllerModel = new CompoundPropertyModel<>(this.controller);
	
		// fields
		this.add(new TextField<>("name", controllerModel.bind("name")));
	
		this.add(new TextField<>("address", controllerModel.bind("address")));
		this.add(new NumberTextField<>("landphone", controllerModel.bind("landphone")));
		this.add(new NumberTextField<>("alternativePhone", controllerModel.bind("alternativePhone")));
		
		this.add(new DropDownChoice<>(
				"sector"   // id
				, controllerModel.bind("sector")   // value binding
				, controllerModel.bind("sectorToShow")   // list-of-options binding
				, new ChoiceRenderer<>("name")    // what to show for each option   
		));

		@SuppressWarnings("unchecked")
		ListView listView = new ListView("list", controller.checked){
			private static final long serialVersionUID = 863206267687440733L;

			protected void populateItem(ListItem item){
                CheckController controller = (CheckController)item.getModelObject();
                item.add(new Label("name", controller.getName()));
                item.add(new CheckBox("check", new PropertyModel(controller, "checked")));
            }
        };
         listView.setReuseItems(true);
         add(listView);
    }

	private void fillOkCancelButtons() {
		Link<String> cancelAction = new Link<String>("cancelAction") {
			private static final long serialVersionUID = 3251048626635072477L;
	
			@Override
			public void onClick() {
				this.setResponsePage(new AddPharmacyPage());
				
			}
		}; 
		this.add(cancelAction);

}
}

