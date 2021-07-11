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

import com.aem.ayansh.core.service.AyanshI;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Pen Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "sling.servlet.paths="+"/bin/Pen"
})



public class Pen extends SlingAllMethodsServlet {
	
	protected static final Logger log=LoggerFactory.getLogger(Pen.class);
@Reference
AyanshI obj;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	log.info("hai helloooooooo**********************");
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	response.getWriter().write("hai******************");
	Connection con=obj.getDataBaseConnection("employ");
	log.info("succesfully entered into servlet******"+con);
}
}
