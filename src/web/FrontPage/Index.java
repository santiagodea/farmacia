package web.FrontPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import modeloFarmacia.PharmApp;
import modeloFarmacia.Pharmacy;

public class Index extends WebPage {
	private static final long serialVersionUID = 6806387568694518454L;

	IndexController controller;
	
	public Index(){
		super();
		this.controller = new IndexController();
		this.fillLinks();
		this.fillPharmacyShifts();
	}

	private void fillLinks() {
		Link<String> backLink = new Link<String>("backDate") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(Index.class);
			}
		};
		
		Link<String> nextLink = new Link<String>("nextDate") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(Index.class);
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
			}
		};
		
		this.add(list);
	}
	
}
