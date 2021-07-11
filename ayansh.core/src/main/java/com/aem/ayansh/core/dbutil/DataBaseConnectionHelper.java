/*
 * package com.aem.ayansh.core.dbutil;
 * 
 * import java.io.PrintWriter; import java.io.StringWriter; import
 * java.sql.Connection;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference; import org.slf4j.Logger;
 * import org.slf4j.LoggerFactory;
 * 
 * 
 * import com.day.commons.datasource.poolservice.DataSourcePool;
 * 
 * //creating osgi service for my java class
 * 
 * @Component(immediate=true,service=DataBaseConnectionHelper.class) public
 * class DataBaseConnectionHelper {
 * 
 * 
 * protected static final Logger
 * log=LoggerFactory.getLogger(DataBaseConnectionHelper.class);
 * 
 * //predefing osgi service
 * 
 * @Reference DataSourcePool dataSourceService;//sourcepool obj Connection
 * con=null;
 * 
 * public Connection getDataBaseConnection(String dataSourceName) {
 * 
 * log.info("getDataBase Started *****"); try {
 * 
 * by using datasource poll obj we r geeting datasource object by using
 * datasource object we r calling get connection method
 * 
 * DataSource dataSource=(DataSource)
 * dataSourceService.getDataSource(dataSourceName);
 * con=dataSource.getConnection();
 * log.info("MySql Database Connection Successfully Established "+con); } catch
 * (Exception e) {
 * 
 * StringWriter sw=new StringWriter(); e.printStackTrace(new PrintWriter(sw));
 * log.info(sw.toString()); //e.printStackTrace();
 * 
 * }
 * 
 * return con;
 * 
 * 
 * } }
 */