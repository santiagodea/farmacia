package web.SocialWorkLoad;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

import web.LoadPharmacy.PagePharmacy;

public class AddSocialWorkPage extends WebPage {
	private static final long serialVersionUID = -784961065925407069L;
	
	// VARIABLES
		protected SocialWorkEditionController controller;

		// CONSTRUCTORES
		public AddSocialWorkPage() {
			super();
			this.controller = new SocialWorkEditionController();
			this.fillForm();
		}

		public AddSocialWorkPage(SocialWorkEditionController controller) {
			super();
			this.controller = controller;
			this.fillForm();
		}

		private void fillForm() {
			Form<SocialWorkEditionController> socialWorkMainDataForm = new Form<SocialWorkEditionController>("SocialWorkForm") {
				private static final long serialVersionUID = -5411419842286128197L;

				@Override
				protected void onSubmit() {

					try {
						AddSocialWorkPage.this.controller.accept();
						this.setResponsePage(PagePharmacy.class);
					} catch (Exception e) {

						this.setResponsePage(getPage());
					}
				}
			};
			socialWorkMainDataForm.add(new SocialWorkEditionPanel("socialWorkFormFields", this.controller));
			this.add(socialWorkMainDataForm);
		}	

}
