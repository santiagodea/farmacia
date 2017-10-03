	package web.LoadCycle.newCycle;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

import web.LoadCycle.mainAdmin.ControllerMainAdmin;
import web.LoadCycle.mainAdmin.MainAdmin;

public class NewCyclePage extends WebPage {
	private static final long serialVersionUID = 3695601646925192219L;
	
	protected CycleController controller;
	protected ControllerMainAdmin controllerMain;
	
	public NewCyclePage() {
		super();
		this.controller = new CycleController(controllerMain.getActualSector());
		this.fillForm();
	}
	
	public NewCyclePage(ControllerMainAdmin controllerM) {
		super();
		this.controllerMain = controllerM;
		this.controller = new CycleController(controllerMain.getActualSector());
		this.fillForm();
	}

	private void fillForm() {
		Form<CycleController> cycleMainDataForm = new Form<CycleController>("cycleForm") {
			private static final long serialVersionUID = -5411419842286148197L;
			@Override
			protected void onSubmit() {
				System.out.println("que vergaaaaaaaaaaaa");
				NewCyclePage.this.controller.accept();
				this.setResponsePage(MainAdmin.class);
			}	
	};
		cycleMainDataForm.add(new CyclePanel("cycleFields", this.controller));
		this.add(cycleMainDataForm);
		
	}

	public ControllerMainAdmin getControllerMain() {
		return controllerMain;
	}
}
