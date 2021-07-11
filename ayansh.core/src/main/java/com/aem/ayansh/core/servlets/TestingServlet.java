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

import com.aem.ayansh.core.service.MyInterface;


@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Testing Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/TestingServlet"
})

public class TestingServlet extends SlingSafeMethodsServlet{
private static final long serialVersionUid=1L;
protected static final Logger log=LoggerFactory.getLogger(TestingServlet.class);
@Reference
MyInterface obj;
	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {
		final Resource resourse=request.getResource();
		response.setContentType("text/plain");
		// TODO Auto-generated method stub
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		obj.addEmp(firstName, lastName, email);

		response.getWriter().write("I Am From chandu");
	}
}
