package com.aem.ayansh.core.customosgiconfig;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="employ details configuration",description="this configuration reads values of employ details")
public @interface OsgiConfiguration {
@AttributeDefinition(name="employId",description="enter employId",type=AttributeType.INTEGER)
	public int getemployId();
@AttributeDefinition(name="employName",description="enter employ name",type=AttributeType.STRING)
public String getemployName();
@AttributeDefinition(name="employSalary",description="enter employ salary",type=AttributeType.INTEGER)
public int getemploySalary();




}
