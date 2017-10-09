package web.SocialWorkLoad;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class SocialWorkPanel extends Panel {
	private static final long serialVersionUID = 7986364121663778516L;
	
	private SocialWorkController controller;
	
	public SocialWorkPanel(String id, SocialWorkController controller){
		super(id);
		
		this.controller = controller;
		
		this.add(new Label("name", new PropertyModel<>(this.controller, "chosenPharmacy.name")));
		this.add(new Label("address", new PropertyModel<>(this.controller, "chosenPharmacy.address")));
		this.add(new Label("landphone", new PropertyModel<>(this.controller, "chosenPharmacy.landphone")));
		
		ListView<ControllerCheck> listView = new ListView<ControllerCheck>("list", controller.checked){
			private static final long serialVersionUID = 863206267287450733L;

			
			protected void populatItem(ListItem<ControllerCheck> item){
				ControllerCheck controller = item.getModelObject();
				item.add(new Label("name", controller.getName()));
			}
		};
		listView.setReuseItems(true);
		add(listView);
	}

	@Override
	public boolean isVisible() {
		return super.isVisible() && this.controller.hasChosenSocialWork();
				
	}
	
}
