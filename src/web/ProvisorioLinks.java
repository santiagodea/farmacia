package web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import web.FrontPage.Index;
import web.LoadPharmacy.PagePharmacy;

public class ProvisorioLinks extends WebPage{
	private static final long serialVersionUID = 851945421535409026L;

	public ProvisorioLinks(){
		
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
		
	}
}
