package web.LoadPharmacy;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;

public class PagePharmacy extends WebPage {
	private static final long serialVersionUID = -385733004769762315L;

	private ControllerPharmacy controller;
	public PagePharmacy() {
		super();
		this.fillAddButton();
		this.controller = new ControllerPharmacy();
		this.fillPharmacy();
		this.add(new PharmacyPanel("infoPharmacy", this.controller));
	}
	
	
	protected void fillAddButton() {
		Link<String> addAction = new Link<String>("addPharmacy") {
			private static final long serialVersionUID = -901862819067967823L;

			@Override
			public void onClick() {
				this.setResponsePage(AddPharmacyPage.class);
				
			}
		}; 
		this.add(addAction);
	}
	
	

	protected void fillPharmacy() {
		this.add(new ListView<Pharmacy>("pharmacyList", new PropertyModel<>(this.controller,"pharmacyList")) {
			private static final long serialVersionUID = -4547597546545617797L;

			@Override
			protected void populateItem(ListItem<Pharmacy> panel) {
				Pharmacy thePharmacy = panel.getModelObject();
				final Link<String> nameLink = new Link<String>("name") {
					private static final long serialVersionUID = 4224659757950892063L;

					@Override
					public void onClick() {
						PagePharmacy.this.controller.setChosenPharmacy(thePharmacy);
						
					}
					
				};
				nameLink.setBody(new PropertyModel<>(thePharmacy, "name"));
				panel.add(nameLink);
				panel.add(new Label("address", new PropertyModel<>(thePharmacy, "address")));
				panel.add(new Label("landphone", new PropertyModel<>(thePharmacy, "landphone")));			
			}
		});
		
	}
	
	
	//setter & getter
	public ControllerPharmacy getController() {
		return controller;
	}
	public void setController(ControllerPharmacy controller) {
		this.controller = controller;
	}

}