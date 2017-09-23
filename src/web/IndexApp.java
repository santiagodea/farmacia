package web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import web.FrontPage.Index;


public class IndexApp extends WebApplication {
	@Override
	public Class<? extends Page> getHomePage() {
		
		return ProvisorioLinks.class;
	}
}
