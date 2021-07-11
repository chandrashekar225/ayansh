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

import com.aem.ayansh.core.dbutil.DataBaseConnection;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Pencil Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
        "sling.servlet.extensions=" + "txt",
        "sling.servlet.paths="+"/bin/rubber"
        
})
public class Pencil extends SlingAllMethodsServlet {
	protected static final Logger log=LoggerFactory.getLogger(Pencil.class);
	
	@Reference
	DataBaseConnection obj;
	Connection con=null;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		log.info("enterd Into Servlet**********************");
		response.getWriter().write("hello this is chandu");
		con=obj.getConnection("employ");
		//log.info("successfully connection got to servlet================="+con);
	}
	
}
