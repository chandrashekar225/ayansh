package com.aem.ayansh.core.service;

import com.aem.ayansh.core.bean.NodeOprations;

public interface NodeOprationsI {

	public boolean registerEmployDetails(String firstName,String lastName,String userName,String password);
	public boolean employLogin(String userName,String password);
	public NodeOprations getNodeProperties();
	public boolean getChildNodeProperties();

	
}
