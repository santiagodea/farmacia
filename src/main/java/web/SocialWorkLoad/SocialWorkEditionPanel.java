package web.SocialWorkLoad;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;
import modeloFarmacia.SocialWork;
import web.LoadPharmacy.AddPharmacyPage;
import web.LoadPharmacy.CheckController;
import web.LoadPharmacy.PagePharmacy;
import web.LoadPharmacy.PharmacyEditionController;

public class SocialWorkEditionPanel extends Panel{
	private static final long serialVersionUID = -8102736994964968242L;

	//ATRIBUTOS
		protected SocialWorkEditionController controller;
		protected List<Pharmacy> thePharmacys = PharmApp.store().pharmacyList();
		//CONSTRUCTOR
		public SocialWorkEditionPanel(String id, SocialWorkEditionController _controller) {
			super(id);
			this.controller = _controller;
			this.fillChecked();
			this.fillPanel();
			this.fillOkDeleteButtons();
			this.fillCancelButton();
		}
		


		//METODOS
		private void fillChecked() {
			thePharmacys.forEach(s -> controller.checked.add(new ControllerCheck(s)));
		}

		protected void fillPanel() {
			CompoundPropertyModel<SocialWorkEditionController> controllerModel = new CompoundPropertyModel<>(this.controller);

			// CAMPOS
			this.add(new TextField<>("name", controllerModel.bind("name")));

			this.add(new TextField<>("address", controllerModel.bind("address")));
			this.add(new NumberTextField<>("landphone", controllerModel.bind("landphone")));


			ListView<ControllerCheck> listView = new ListView<ControllerCheck>("list", controller.checked) {
				private static final long serialVersionUID = 863206167687440733L;

				protected void populateItem(ListItem<ControllerCheck> item) {
					ControllerCheck controller = item.getModelObject();
					item.add(new Label("name", controller.getName()));
					item.add(new CheckBox("check", new PropertyModel<>(controller, "checked")));
				}
			};
			listView.setReuseItems(true);
			add(listView);

			this.add(new Label("error", controllerModel.bind("ControllerErrorMsg")));
		}

		private void fillOkDeleteButtons() {
			Link<String> cancelAction = new Link<String>("deleteAction") {
				private static final long serialVersionUID = 3251048626635072477L;

				@Override
				public void onClick() {
					this.setResponsePage(new AddSocialWorkPage());

				}
			};
			this.add(cancelAction);

		}
		private void fillCancelButton() {
			Link<String> cancelAction = new Link<String>("cancelAction") {
				private static final long serialVersionUID = 3251048626635072477L;

				@Override
				public void onClick() {
					this.setResponsePage(new SocialWorkPage());

				}
			};
			this.add(cancelAction);
			
		}	


}
