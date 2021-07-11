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

import com.aem.ayansh.core.bean.NodeOprations;
import com.aem.ayansh.core.service.NodeOprationsI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=NodeLoginServlet Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/nodeLoginServlet"
})
public class NodeLoginServlet extends SlingAllMethodsServlet {
	
	@Reference
	NodeOprationsI login;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	String userName=request.getParameter("uname");
	String Password=request.getParameter("pwd");
	NodeOprations bean=new NodeOprations();
	try {
		boolean b=login.employLogin(userName, Password);
		
		if (b) {
			response.getWriter().write("logged succesfully*****************"+b);
		} else {
			response.getWriter().write("something went Wrong*****************");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}

}
}
