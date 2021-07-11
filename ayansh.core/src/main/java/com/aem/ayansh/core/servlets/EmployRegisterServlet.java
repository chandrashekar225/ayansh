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

import com.aem.ayansh.core.service.EmployI;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Student Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/EmployRegisterServlet"
})
public class EmployRegisterServlet extends SlingAllMethodsServlet {

	@Reference
	EmployI emp;
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(request, response);
		String EmployName=request.getParameter("empname");
		String EmployId=request.getParameter("empid");
		String salary=request.getParameter("slry");
		String location=request.getParameter("loc");
		try {
			boolean b=emp.add(EmployName, EmployId, salary, location);
			if (b) {
				response.getWriter().write("registererd successfully*******"+b);
				response.getWriter().write("EmployName"+EmployName+"EmployId"+EmployId+"salary"+salary+"location"+location);
			} else {
response.getWriter().write("something went wrong.....");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}



	}
}
