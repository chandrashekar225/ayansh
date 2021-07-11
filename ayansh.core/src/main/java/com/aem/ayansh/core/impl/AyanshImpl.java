package com.aem.ayansh.core.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.service.AyanshI;
import com.aem.ayansh.core.service.MyInterface;
import com.day.commons.datasource.poolservice.DataSourcePool;


@Component(service=AyanshI.class,immediate = true)
public class AyanshImpl implements AyanshI{
	protected static final Logger log=LoggerFactory.getLogger(AyanshImpl.class);

	
	@Reference
	 DataSourcePool dataSourceService;//sourcepool obj             
	Connection con=null;
	@Override
	public boolean addAem(String fName, String LName) {
		log.info("fName=============="+fName);
		log.info("LName=============="+LName);

try {
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
		
		
		
		
		
		return false;
	}

	@Override
	public Connection getDataBaseConnection(String dataSourceName) {

		log.info("getDataBase Started *****");
		try {
			
			/*by using datasource poll obj we r geeting datasource object 
			by using datasource object  we r calling get connection method*/
	
			DataSource dataSource=(DataSource) dataSourceService.getDataSource(dataSourceName);
			con=dataSource.getConnection();
			log.info("MySql Database Connection Successfully Established "+con);
		} catch (Exception e) {
			
			StringWriter sw=new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			log.info(sw.toString());
			//e.printStackTrace();
			
		}
		
		return con;
		
	}

}
