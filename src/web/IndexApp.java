package web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import web.FrontPage.Index;


public class IndexApp extends WebApplication {
	@Override
	public Class<? extends Page> getHomePage() {
		
		return Index.class;
	}
	
    @Override
    protected void init()
    {
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8"); 
    }
}
