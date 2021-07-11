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

import com.aem.ayansh.core.bean.Student;
import com.aem.ayansh.core.service.StudentI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=GetStudentDetailsByEmail Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/getStudentDetailsByEmail"
})
public class GetStudentDetailsByEmail extends SlingAllMethodsServlet {
	
@Reference
StudentI getStdDetailsByEmail;
@Override
protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(request, response);
	String email=request.getParameter("email");
	try {
		
		 Student std=getStdDetailsByEmail.getStudentDetailsByEmail(email);
		 response.getWriter().write("get student details by eamil***********"+std);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
