package web.LoadPharmacy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class PharmacyPanel  extends Panel{
	private static final long serialVersionUID = -6732870436085426588L;
	
	
	private ControllerPharmacy controller;
	
	private void fillChecked() {
		controller.getChosenPharmacy().getSocialWorks().forEach(s -> controller.checked.add(new CheckController(s, false)));	
	}
	public PharmacyPanel(String id, ControllerPharmacy pageController) {
		super(id);
		
		this.controller = pageController;
		
		this.add(new Label("name", new PropertyModel<>(this.controller, "chosenPharmacy.name")));
		this.add(new Label("address", new PropertyModel<>(this.controller, "chosenPharmacy.address")));
		this.add(new Label("landphone", new PropertyModel<>(this.controller, "chosenPharmacy.landphone")));
		this.add(new Label("alternativePhone", new PropertyModel<>(this.controller, "chosenPharmacy.alternativePhone")));
		
		//NO ANDA - TENGO QUE MOSTRAR ALGO ASI: "OSDE,IOMA, GALENO".
		

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
	
//	protected void populateItem(ListItem<Pharmacy> panel) {
//		Pharmacy thePharmacy = panel.getModelObject();
//		final Link<String> nameLink = new Link<String>("name") {
//			private static final long serialVersionUID = 4224659757950892063L;
//
//			@Override
//			public void onClick() {
//				PagePharmacy.this.controller.setChosenPharmacy(thePharmacy);
//				
//			}
			
//		};
//		nameLink.setBody(new PropertyModel<>(thePharmacy, "name"));
//		panel.add(nameLink);
//		panel.add(new Label("address", new PropertyModel<>(thePharmacy, "address")));
//		panel.add(new Label("landphone", new PropertyModel<>(thePharmacy, "landphone")));	
//		
//	}



	@Override
	public boolean isVisible() {
		return super.isVisible() && this.controller.hasChosenPharmacy();
	}

}


//private BandPageController controller;
//
//public AlbumPanel(String id, BandPageController pageController) {
//	super(id);
//	this.controller = pageController;
//
//	this.add(new Label("nombreDiscoElegido", new PropertyModel<>(this.controller, "chosenAlbum.nombre")));
//
//	this.add(new ListView<CopiasVendidas>("copiasPorPais", new PropertyModel<>(this.controller, "chosenAlbum.copiasPorPais")) {
//		private static final long serialVersionUID = -4589934709866990333L;
//
//		@Override
//		protected void populateItem(ListItem<CopiasVendidas> panel) {
//			panel.add(new Label("pais", new PropertyModel<>(panel.getModelObject(), "pais.nombre")));
//			panel.add(new Label("cantidadCopias", new PropertyModel<>(panel.getModelObject(), "cantidad")));				
//		}
//	});
//}
//
//@Override
//public boolean isVisible() {
//	return super.isVisible() && this.controller.hasChosenAlbum();
//}
//
//
//}