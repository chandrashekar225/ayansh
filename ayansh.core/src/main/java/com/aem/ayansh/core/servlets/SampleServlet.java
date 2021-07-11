package com.aem.ayansh.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.service.SampleInterface;



@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Sample Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/SampleServlet"
})
public class SampleServlet extends SlingSafeMethodsServlet{
	
	private static final long serialVersionUid=1L;
	protected static final Logger log=LoggerFactory.getLogger(SampleServlet.class);
	
	
	@Reference
	SampleInterface obj;
	

@Override
protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	//super.doGet(request, response);
	final Resource resourse=request.getResource();

	
	 response.setContentType("text/plain"); 
	  
	 
	 response.getWriter().write("hai this this chandu from andugulapalli");
}
}
