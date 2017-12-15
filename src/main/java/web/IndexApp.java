package web;


import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

import api.PharAppRestResource;
import web.FrontPage.Index;


public class IndexApp extends WebApplication {
	@Override
	public Class<? extends Page> getHomePage() {
		
		return Index.class;
	}
	/*
	 * Paso 3: agregar el metodo init() en la clase que extiende WebApplication
	 * (que es la referenciada desde web.xml)
	 * 
	 */
    @Override
    protected void init()
    {
    	super.init();
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8"); 
    
		// aca "/api" es la primer parte de la URL, va a ser todo
		// ...:8080/api/...
		// MonstersRestResource es la clase del paso 1
		// el resto del codigo lo copia miserablemente
		
        this.mountResource("/api", new ResourceReference("restReference") {
			private static final long serialVersionUID = 2337438202065386511L;
			PharAppRestResource resource = new PharAppRestResource();
			@Override
			public IResource getResource() {
				return resource;
			}

		});
    
    
    }
    



}
