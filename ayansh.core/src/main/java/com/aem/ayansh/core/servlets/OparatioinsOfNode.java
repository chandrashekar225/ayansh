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

import com.aem.ayansh.core.service.NodeOprationsI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=NodeOparationsServlet Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/oparatioinsOfNode"
})
public class OparatioinsOfNode extends SlingAllMethodsServlet {
	@Reference
	NodeOprationsI nodeRegistrtion;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	String firstName=request.getParameter("fname");
	String lastName=request.getParameter("lname");
	String userName=request.getParameter("uname");
	String password=request.getParameter("pwd");
	//log.info("enterd into ");
	try {
		nodeRegistrtion.registerEmployDetails(firstName, lastName, userName, password);
		
		response.getWriter().write("firstName===="+firstName+"lastName====="+lastName+"userName===="+userName+"password==="+password);
		
	} catch (Exception e) {
		// TODO: handle exception
	}

	

}
}
