package com.aem.ayansh.core.slingmodels;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;


@Model(adaptables=Resource.class)

public class GetNodeProperties {
	
	@Inject
	private String lastName;

	public String getLastName() {
		return lastName;
	}
@Self
Resource currenResource;

	
	
	@PostConstruct
	protected void init() {
		try {
			Node currentNode=currenResource.adaptTo(Node.class);
			lastName=currentNode.getProperty("lastName").getString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	

}
