package com.aem.ayansh.core.servlets;

import java.io.IOException;
import java.sql.Connection;

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

import com.aem.ayansh.core.impl.AyanshImpl;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Ayansh Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "sling.servlet.paths="+"/bin/test"
})

public class Ayansh extends SlingAllMethodsServlet{
	private static final long serialVersionUid=1L;
	protected static final Logger log=LoggerFactory.getLogger(Ayansh.class);
	
	 
	
		
		 //@Reference 
		// private DataBaseConnectionHelper conHelper;
		 
	@Reference 
	AyanshImpl obj;
	  @Override
protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	
	/*
	 * String firstName=request.getParameter("fName"); 
	 * String lastName=request.getParameter("lName");
	 * 
	 * 
	 * response.getWriter().write("======="+firstName);
	 * response.getWriter().write("======="+lastName);
	 */
	 
}
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		
		  //log.info("servlet called***************");
		// obj.getDataBaseConnection("employ");
		  //obj.addAem("chandu", "shekar");
		// log.info("Connection hitted the servlet and successfully "+con);
		//Connection con=obj.getDataBaseConnection("employ");
		//log.info("servlet hitted*****************"+con);
		
		 
		 
	}
}
