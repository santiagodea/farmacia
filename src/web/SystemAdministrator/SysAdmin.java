package web.SystemAdministrator;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import web.FrontPage.Index;
import web.LoadCycle.mainAdmin.MainAdmin;
import web.LoadPharmacy.PagePharmacy;
import web.SocialWorkLoad.SocialWorkPage;

public class SysAdmin extends WebPage{
	private static final long serialVersionUID = 851945421535409026L;

	public SysAdmin(){
		
		this.add(new Link<String>("index") {
			private static final long serialVersionUID = -3690151360490159036L;

			@Override
			public void onClick() {
				this.setResponsePage(Index.class);
			}
		});
		
		
		this.add(new Link<String>("pagePharmacy") {
			private static final long serialVersionUID = -3690151360490159036L;

			@Override
			public void onClick() {
				this.setResponsePage(PagePharmacy.class);
			}
		});
		
		this.add(new Link<String>("pageMainAdmin") {
			private static final long serialVersionUID = -3690151360490159036L;

			@Override
			public void onClick() {
				this.setResponsePage(MainAdmin.class);
			}
		});
		
		this.add(new Link<String>("socialWorkPage") {
			private static final long serialVersionUID = -3690151360490159036L;

			@Override
			public void onClick() {
				this.setResponsePage(SocialWorkPage.class);
			}
		});
		
	}
}
