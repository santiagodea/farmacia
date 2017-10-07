package web.SocialWorkLoad;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.SocialWork;

public class SocialWorkPage extends WebPage {
	private static final long serialVersionUID = 6978760694503924317L;
	
	private SocialWorkController controller;
	
	public SocialWorkPage(){
		super();
		this.fillAddButton();
		this.controller = new SocialWorkController();
		this.fillSocialWork();
		this.add(new SocialWorkPanel("socialWorkPanel", this.controller));
	}
	
	protected void fillAddButton(){
		Link<String> addAction = new Link<String>("addSocialWork") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(AddSocialWorkPage.class);;
			}
			
		};
		this.add(addAction);
	}
	
	protected void fillSocialWork(){
		this.add(new ListView<SocialWork>("socialWorkList", new PropertyModel<>(this.controller, "socialWorlList")){
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<SocialWork> panel) {
				SocialWork theSocialWork = panel.getModelObject();
				final Link<String> linkName = new Link<String>("name") {
					private static final long serialVersionUID = 9010292990028577143L;

					@Override
					public void onClick() {
						SocialWorkPage.this.controller.setChosenSocailWork(theSocialWork);
					}
				};
				linkName.setBody(new PropertyModel<>(theSocialWork, "name"));
				panel.add(linkName);
				panel.add(new Label("landphone", new PropertyModel<>(theSocialWork, "landPhone")));
			}	
	});
	}
	
	//setter and getters
	public SocialWorkController getController(){
		return controller;
	}
	public void setController(SocialWorkController controller){
		this.controller = controller;
	}
}
