package web.LoadCycle.mainAdmin;

public abstract class Controller {
	protected String controllerErrorMsg = "";

	public String getControllerErrorMsg() {
		return controllerErrorMsg;
	}

	public void setControllerErrorMsg(String controllerErrorMsg) {
		this.controllerErrorMsg = controllerErrorMsg;
	}
	
	
}
