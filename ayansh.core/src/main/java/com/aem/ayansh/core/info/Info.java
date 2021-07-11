package com.aem.ayansh.core.info;

import com.adobe.cq.sightly.WCMUsePojo;

public class Info extends WCMUsePojo {
	
	private String lowerCaseTitle;
	private String lowerCaseDescription;

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
		lowerCaseTitle= getProperties().get("titlename", "").toLowerCase();
		lowerCaseDescription= getProperties().get("description", "").toLowerCase();		
	}

	public String getLowerCaseTitle() {
		return lowerCaseTitle;
	}

	public String getLowerCaseDescription() {
		return lowerCaseDescription;
	}
	
	
	

}
