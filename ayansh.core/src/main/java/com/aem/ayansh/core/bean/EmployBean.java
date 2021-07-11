package com.aem.ayansh.core.bean;

public class EmployBean {

	private String EmployName;
	
	private String EmployId;
	private String salary;
	private String location;
	public String getEmployName() {
		return EmployName;
	}
	public void setEmployName(String employName) {
		EmployName = employName;
	}
	public String getEmployId() {
		return EmployId;
	}
	public void setEmployId(String employId) {
		EmployId = employId;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "EmployBean [EmployName=" + EmployName + ", EmployId=" + EmployId + ", salary=" + salary + ", location="
				+ location + "]";
	}
	

}
