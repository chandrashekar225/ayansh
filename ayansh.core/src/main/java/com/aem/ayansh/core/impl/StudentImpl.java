package com.aem.ayansh.core.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.ayansh.core.bean.Student;
import com.aem.ayansh.core.dbutil.DataBaseConnection;
import com.aem.ayansh.core.service.StudentI;

@Component(service=StudentI.class,immediate = true)

public class StudentImpl implements StudentI{
	protected static final Logger log=LoggerFactory.getLogger(StudentImpl.class);
	
	Connection con=null;
	PreparedStatement ps=null;
	@Reference
	DataBaseConnection objss;
	@Override
	public boolean addStudent(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		String sql = "insert into student(firstName, lastName, email) values(?,?,?)";
		boolean flag=false;
		log.info("enterd into the implimentation classs************");
		try {
			con=objss.getConnection("employ");
			ps=con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
				log.info("recorded sucessfully*******");
			} else {
				flag=false;
				log.info("OOOOOps..............");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		
		return flag;
	}
	@Override
	public boolean updateStudentDetails(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		String mysql=("update student set firstName=?,lastName=? where email=?");	
		boolean flag=false;
		try {
			con=objss.getConnection("employ");
			ps=con.prepareStatement(mysql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
			} else {
				flag=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
	@Override
	public boolean deleteStudentDetailsByEmail(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		String sql=("delete from student where email=?");
		boolean flag=false;
		try {
			con=objss.getConnection("employ");
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
			} else {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (con!=null) {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
			}
		}
		return flag;
	}
	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		String sql = ("select * from student");
		boolean flag = false;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		try {
			con=objss.getConnection("employ");
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			//list= new ArrayList<Student>();
			
			while (rs.next()) {
				Student std=new Student();
				std.setFirstName(rs.getString(1));
				std.setLastName(rs.getString(2));
				std.setEmail(rs.getString(3));
				list.add(std);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
		return list;
	}
	@Override
	public Student getStudentDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String sql=("select * from student where email=?");
		Student std=new Student();
		try {
			con=objss.getConnection("employ");
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if (rs.next()) {
				std.setFirstName(rs.getString(1));
				std.setLastName(rs.getString(2));
				std.setEmail(rs.getString(3));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return std;
	}
	
	
	
	
	

}
