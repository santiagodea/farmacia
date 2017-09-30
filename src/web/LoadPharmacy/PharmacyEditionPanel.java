package web.LoadPharmacy;




import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import modeloFarmacia.PharmApp;
import modeloFarmacia.SocialWork;

public class PharmacyEditionPanel extends Panel{
	private static final long serialVersionUID = 2451481869719251482L;

	protected PharmacyEditionController controller;
	List<SocialWork> theSocials = PharmApp.store().getSocialWorks();

	
	public PharmacyEditionPanel(String id, PharmacyEditionController _controller) {
		super(id);
		this.controller = _controller;
		this.fillPanel();
		this.fillOkCancelButtons();
		
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
	
//	this.add(new CheckBoxMultipleChoice<SocialWork>("socialWork", 
//									new ListModel<SocialWork>(new ArrayList<SocialWork>()), 
//									theSocials, 
//									new ChoiceRenderer<SocialWork>("name"))); 
//	
//	
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
	
//		Link<String> confirmAction = new Link<String>("doAddPharmacy") {
//			private static final long serialVersionUID = 6693007657356760682L;
//	
//			@Override
//			public void onClick() {
//				PharmacyEditionPanel.this.controller.accept();
//				this.setResponsePage(PagePharmacy.class);				
//			}
//		}; 
//		this.add(confirmAction);
}
}

