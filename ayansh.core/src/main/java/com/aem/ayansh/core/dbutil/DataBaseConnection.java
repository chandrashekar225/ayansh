package com.aem.ayansh.core.dbutil;

import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;

@Component(service=DataBaseConnection.class,immediate = true)

public class DataBaseConnection {
	protected static final Logger log=LoggerFactory.getLogger(DataBaseConnection.class);
	Connection con=null;
	@Reference
	DataSourcePool datasoursobj;
public Connection getConnection(String dataSourceName) {
	log.info("entered into databaseConnection================");
	try {
		DataSource datasourse=(DataSource) datasoursobj.getDataSource(dataSourceName);
		con=datasourse.getConnection();
		log.info("successfully established database*********************"+con);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return con;
	
	
	
}
}
