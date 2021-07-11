package com.aem.ayansh.core.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.ayansh.core.dbutil.DataBaseConnection;
import com.aem.ayansh.core.service.BankI;

@Component(service=BankI.class,immediate = true)

public class BankImpl implements BankI {

	Connection con=null;
	PreparedStatement ps=null;
	@Reference
	DataBaseConnection DataBaseConnection;
	@Override
	public boolean acRegistration(String AcNumber, String AcHolderName, String Balance, String Location) {
		// TODO Auto-generated method stub
		String sql = "insert into bank(AcNumber, AcHolderName, Balance,Location) values(?,?,?,?)";
		boolean flag=false;
		try {
			con=DataBaseConnection.getConnection("employ");
			ps=con.prepareStatement(sql);
			ps.setString(1, AcNumber);
			ps.setString(2, AcHolderName);
			ps.setString(3, Balance);
			ps.setString(4, Location);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
			} else {
				flag=false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return flag;
	}

}
