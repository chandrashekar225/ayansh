package com.aem.ayansh.core.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.ayansh.core.dbutil.DataBaseConnection;
import com.aem.ayansh.core.service.EmployI;

@Component(service=EmployI.class,immediate = true)

public class EmployImpl implements EmployI {
	Connection con=null;
	PreparedStatement ps=null;
	@Reference
	DataBaseConnection objs;

	@Override
	public boolean add(String EmployName, String EmployId, String salary, String location) {
		// TODO Auto-generated method stub
		String sql="insert into rajini(EmployName,EmployId,salary,location) values(?,?,?,?)";
		
		boolean flag=false;
		try {
			con=objs.getConnection("employ");
			ps=con.prepareStatement(sql);
			ps.setString(1, EmployName);
			ps.setString(2, EmployId);
			ps.setString(3, salary);
			ps.setString(4, location);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
			} else {
flag=false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		}
		
		
		
		return flag;
	}
	

}
