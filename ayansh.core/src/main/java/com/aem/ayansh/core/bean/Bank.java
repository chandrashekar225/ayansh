package com.aem.ayansh.core.bean;

public class Bank {
private String AcNumber;
private String AcHolderName;
private String Balance;
private String Location;
public String getAcNumber() {
	return AcNumber;
}
public void setAcNumber(String acNumber) {
	AcNumber = acNumber;
}
public String getAcHolderName() {
	return AcHolderName;
}
public void setAcHolderName(String acHolderName) {
	AcHolderName = acHolderName;
}
public String getBalance() {
	return Balance;
}
public void setBalance(String balance) {
	Balance = balance;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
@Override
public String toString() {
	return "Bank [AcNumber=" + AcNumber + ", AcHolderName=" + AcHolderName + ", Balance=" + Balance + ", Location="
			+ Location + "]";
}

}
