package web.LoadPharmacy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class PharmacyPanel  extends Panel {
	private static final long serialVersionUID = -6732870436085426588L;
	
	
	private ControllerPharmacy controller;
	
	public PharmacyPanel(String id, ControllerPharmacy pageController) {
		super(id);
		
		this.controller = pageController;
		
		this.add(new Label("name", new PropertyModel<>(this.controller, "chosenPharmacy.name")));
		this.add(new Label("address", new PropertyModel<>(this.controller, "chosenPharmacy.address")));
		this.add(new Label("landphone", new PropertyModel<>(this.controller, "chosenPharmacy.landphone")));
		this.add(new Label("alternativePhone", new PropertyModel<>(this.controller, "chosenPharmacy.alternativePhone")));
		
		//NO ANDA - TENGO QUE MOSTRAR ALGO ASI: "OSDE,IOMA, GALENO". si anda
		

		@SuppressWarnings("unchecked")
		ListView listView = new ListView("list", controller.checked){
			private static final long serialVersionUID = 863206267687450733L;

			protected void populateItem(ListItem item){
                CheckController controller = (CheckController)item.getModelObject();
                item.add(new Label("name", controller.getName()));
            }
        };
         listView.setReuseItems(true);
         add(listView);
	}
	

	@Override
	public boolean isVisible() {
		return super.isVisible() && this.controller.hasChosenPharmacy();
	}

}
