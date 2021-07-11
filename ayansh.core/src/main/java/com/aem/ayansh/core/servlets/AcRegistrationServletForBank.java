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

import com.aem.ayansh.core.service.BankI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=AcRegistrationServletForBank Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/acRegistrationServletForBank"
})
public class AcRegistrationServletForBank extends SlingAllMethodsServlet{
	
	@Reference
	BankI AcRegistration;
@Override
protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(request, response);
	String AcNumber=request.getParameter("acnumber");
	String AcHolderName=request.getParameter("acholder");
	String Balance=request.getParameter("balance");
	String Location=request.getParameter("location");
	try {
		boolean b=AcRegistration.acRegistration(AcNumber, AcHolderName, Balance, Location);
		if (b) {
			response.getWriter().write("AcNumber"+AcNumber+" "+"AcHolderName"+AcHolderName+"  "+"Balance"+Balance+"  "+"Location"+Location+"  "+b);
		} else {
			response.getWriter().write("Somthing went Wrong Please Try Again Later..................");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
