package web.SocialWorkLoad;

import org.apache.wicket.markup.html.panel.Panel;

public class SocialWorkPanel extends Panel {
	private static final long serialVersionUID = 7986364121663778516L;
	
	private SocialWorkController controller;
	
	public SocialWorkPanel(String id, SocialWorkController controller){
		super(id);
		this.controller = controller;
	}
	
}
