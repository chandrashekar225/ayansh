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

import com.aem.ayansh.core.impl.RajiniImpl;
import com.aem.ayansh.core.service.RajiniI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=rajini Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "sling.servlet.paths="+"/bin/RajineeServlet"
})
public class RajineeServlet extends SlingAllMethodsServlet {
	protected static final Logger log=LoggerFactory.getLogger(RajineeServlet.class);

	@Reference
	RajiniI obj;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");

		
		response.getWriter().write("this is the first name====="+firstName);
		response.getWriter().write("this is the last name====="+lastName);
		log.info("this is the first name====="+firstName);
		log.info("this is the last name====="+lastName);

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
