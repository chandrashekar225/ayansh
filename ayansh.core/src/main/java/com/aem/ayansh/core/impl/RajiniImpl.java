package com.aem.ayansh.core.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.service.RajiniI;


@Component(service=RajiniI.class,immediate = true)

public class RajiniImpl implements RajiniI {
	protected static final Logger log=LoggerFactory.getLogger(RajiniImpl.class);
	@Override
	public boolean add(String firstName, String lastName) {
		// TODO Auto-generated method stub
		log.info("firstname=="+firstName);
		log.info("lastName=="+lastName);
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
