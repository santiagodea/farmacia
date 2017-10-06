package web.FrontPage;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.Pharmacy;
import modeloFarmacia.SpecialEvent;
import web.SystemAdministrator.SysAdmin;

public class Index extends WebPage {
	private static final long serialVersionUID = 6806387568694518454L;

	IndexController controller;
	
	public Index(){
		super();
		this.controller = new IndexController();
		this.fillToday();
		this.fillLinks();
		this.fillPharmacyShifts();
		this.fillSpecialEvent();
	}
	
	public Index(IndexController controller){
		super();
		this.controller = controller;
		this.fillToday();
		this.fillLinks();
		this.fillPharmacyShifts();
		this.fillSpecialEvent();
	}
	
	

	private void fillToday() {
		Model<String> msjToday = Model.of("HOY");
		Label label = new Label("today", msjToday){
			private static final long serialVersionUID = 4963425868056123732L;

			@Override
			public boolean isVisible() {
				return super.isVisible() && Index.this.controller.getIsToday();
			}
		};
		this.add(label);
	}

	private void fillSpecialEvent() {
		ListView<SpecialEvent> listSE = new ListView<SpecialEvent>("listSpecialEvent", new PropertyModel<>(this.controller, "specialEventsDate") ) { 
			private static final long serialVersionUID = -6370070275502521027L;

			@Override
			protected void populateItem(ListItem<SpecialEvent> panel) {
				SpecialEvent actualSE = panel.getModelObject();
				panel.add(new Label("SEtitle", new PropertyModel<>(actualSE, "title")));
				panel.add(new Label("SEdescription", new PropertyModel<>(actualSE, "description")));
			}
		};
		
		this.add(listSE);
	}

	private void fillLinks() {
		Link<String> adminLink = new Link<String>("admin") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(SysAdmin.class);
			}
		};

		this.add(adminLink);
		
		Link<String> backLink = new Link<String>("backDate") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				Index.this.controller.minusDay();
				this.setResponsePage(Index.this);
			}
		};
		
		Link<String> nextLink = new Link<String>("nextDate") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				Index.this.controller.plusDay();
				this.setResponsePage(Index.this);
			}
		};
		
		this.add(backLink);
		this.add(nextLink);
	}

	private void fillPharmacyShifts() {
		this.add(new Label("date", new PropertyModel<>(this.controller, "date")));


			ListView<Pharmacy> list = new ListView<Pharmacy>("listFarDate", new PropertyModel<>(this.controller, "listPharmacy") ) { 
				private static final long serialVersionUID = -6370070275502521027L;

				@Override
				protected void populateItem(ListItem<Pharmacy> panel) {
					Pharmacy actualPhar = panel.getModelObject();
					panel.add(new Label("pharmacy", new PropertyModel<>(actualPhar, "name")));
					panel.add(new Label("address", new PropertyModel<>(actualPhar, "address")));
				}
			};
			this.add(list);
			this.add(new Label("error",new PropertyModel<>(this.controller, "controllerErrorMsg")));

		}
		
	}
	
