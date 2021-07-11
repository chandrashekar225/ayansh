package com.aem.ayansh.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.service.ShaashiI;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=rajini Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "sling.servlet.paths="+"/bin/ShaashiServlet "
})

public class ShaashiServlet extends SlingAllMethodsServlet {
	protected static final Logger log=LoggerFactory.getLogger(ShaashiServlet.class);

	@Reference
	ShaashiI obj;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		
		response.getWriter().write("firstName is=========="+firstName);
		response.getWriter().write("lastName is=========="+lastName);
		
		log.info("firstname is============="+firstName);
		log.info("lastname is============="+lastName);

	}

}
