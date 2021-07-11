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

import com.aem.ayansh.core.bean.NodeOprations;
import com.aem.ayansh.core.impl.NodeOparationsImpl;
import com.aem.ayansh.core.service.NodeOprationsI;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=GetParentNodePropertiesServ Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/GetParentNodePropertiesServ"
})

public class GetParentNodePropertiesServ extends SlingAllMethodsServlet {
	protected static final Logger log=LoggerFactory.getLogger(GetParentNodePropertiesServ.class);

	@Reference
	NodeOprationsI obj;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			log.info("entered into servlet try***********");
			
			NodeOprations bean =	obj.getNodeProperties();
			log.info("bean*******************"+bean);
			String fname = bean.getFirstName();
		    String lname = 	bean.getLastName();
		    String pwd = 	bean.getPassword();
			String uname = bean.getUserName();
			
			response.getWriter().print(""+fname+""+lname+""+pwd+""+uname);
			log.info(""+fname+""+lname+""+pwd+""+uname);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		//super.doGet(request, response);
	}

}
