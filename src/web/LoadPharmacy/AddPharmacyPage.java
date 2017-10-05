package web.LoadPharmacy;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

import web.LoadCycle.mainAdmin.MainAdmin;
import web.LoadCycle.newCycle.NewCyclePage;

public class AddPharmacyPage extends WebPage {

	private static final long serialVersionUID = 789379717741535051L;
	
	protected PharmacyEditionController controller;
	
	public AddPharmacyPage() {
		super();
		this.controller = new PharmacyEditionController();
		this.fillForm();
	}
	
	public AddPharmacyPage(PharmacyEditionController control) {
		super();
		this.controller = control;
		this.fillForm();	
	}

	private void fillForm() {
		Form<PharmacyEditionController> pharmMainDataForm = new Form<PharmacyEditionController>("pharmacyForm") {
			private static final long serialVersionUID = -5411419842286148197L;
			@Override
			protected void onSubmit() {
				
				try {
					AddPharmacyPage.this.controller.accept();
					this.setResponsePage(PagePharmacy.class);
				} catch (Exception e) {
					
					this.setResponsePage(getPage());
					controller.setError(e.getMessage());
				}
				
				
				
				
				
//				AddPharmacyPage.this.controller.accept();
//				this.setResponsePage(PagePharmacy.class);		
				
//				if (!NewCyclePage.this.controller.isEmpty()) {
//					NewCyclePage.this.controller.accept();
//					this.setResponsePage(MainAdmin.class);
//			}
//			else {
//				this.setResponsePage(getPage());
//				//controller.setError("el CICLO tiene algun campo vacio, por favor complete todos los campos");
//			}
				
				
//				try {
//				this.validate();
//				PharmApp.store().addPharmacyToSector(newPharmacy,sector.getName());
//			} catch (Exception e) {
//				this.setError(e.getMessage());
//			}
				
				
				
				
				
				
				
				
			}	
	};
		pharmMainDataForm.add(new PharmacyEditionPanel("pharmacyFormFields", this.controller));
		this.add(pharmMainDataForm);
		
	}
	
}