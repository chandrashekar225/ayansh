package com.aem.ayansh.core.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.ayansh.core.customosgiconfig.OsgiConfiguration;
import com.aem.ayansh.core.service.CustomOsgiI;
@Component(service=CustomOsgiI.class,immediate = true)
@Designate(ocd=OsgiConfiguration.class)
public class CustomeOsgiImpl implements CustomOsgiI{

	private OsgiConfiguration configuration;
	
	@Activate
	protected void activate(OsgiConfiguration configuration) {
		this.configuration=configuration;
		
	}
	
	@Override
	public String readOsgiConfiguration() {
		// TODO Auto-generated method stub
		int empId=configuration.getemployId();
		String empName=configuration.getemployName();
		int empSalary=configuration.getemploySalary();
		
		return empId+empName+empSalary;
	}

}
