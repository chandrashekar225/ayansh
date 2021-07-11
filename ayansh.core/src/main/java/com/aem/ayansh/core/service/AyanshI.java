package com.aem.ayansh.core.service;

import java.sql.Connection;

public interface AyanshI {
public boolean addAem(String fName,String LName);
public Connection getDataBaseConnection(String dataSourceName) ;
}
