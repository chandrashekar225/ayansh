package com.aem.ayansh.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.models.SlingModel;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=SlingModelServlets Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/SlingModelServlets"
})

public class SlingModelServlets extends SlingAllMethodsServlet {
	protected static final Logger log=LoggerFactory.getLogger(SlingModelServlets.class);
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	try {
		log.info("haiiiii");
		
		ResourceResolver Resourceresolver=request.getResourceResolver();
		Resource resource=Resourceresolver.getResource("/content/shaashikpage/jcr:content/header/slingmodel");
		SlingModel obj=resource.adaptTo(SlingModel.class);
		log.info(obj.getFirstName()+obj.getLastName()+obj.getGender()+obj.getCountry());
		response.getWriter().write(obj.getFirstName()+"*****"+obj.getLastName()+"++++"+obj.getGender()+"===="+obj.getCountry());
		Resourceresolver.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
}
}
