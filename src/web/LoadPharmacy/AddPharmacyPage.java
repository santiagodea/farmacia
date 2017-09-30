package web.LoadPharmacy;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

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
				AddPharmacyPage.this.controller.accept();
				this.setResponsePage(PagePharmacy.class);			
			}	
	};
		pharmMainDataForm.add(new PharmacyEditionPanel("pharmacyFormFields", this.controller));
		this.add(pharmMainDataForm);
		
	}
	
}