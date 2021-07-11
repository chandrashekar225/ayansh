package com.aem.ayansh.core.slingmodels;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class TestModel {
	
	@Inject
	private String titlename;

	@Inject
	private String description;


	@PostConstruct
	protected void init() {
		System.out.println("hai hello");
	}

	public String getTitlename() {
		return titlename;
	}


	public String getDescription() {
		return description;
	}


	}



