package com.aem.ayansh.core.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.service.MyInterface;
import com.aem.ayansh.core.servlets.TestingServlet;


@Component(service=MyInterface.class,immediate = true)
	public class MyInterfaceImpl implements MyInterface {
	protected static final Logger log=LoggerFactory.getLogger(MyInterfaceImpl.class);

	@Override
	public boolean addEmp(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		log.info("firstName==================="+firstName);
		log.info("lastName====================="+lastName);
		log.info("email========================="+email);

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
