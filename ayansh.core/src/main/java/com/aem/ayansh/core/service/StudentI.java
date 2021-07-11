package com.aem.ayansh.core.service;

import java.util.List;

import com.aem.ayansh.core.bean.Student;

public interface StudentI {
public boolean addStudent(String firstName,String lastName,String email);
public boolean updateStudentDetails(String firstName,String lastName,String email);
public boolean deleteStudentDetailsByEmail(String firstName,String lastName,String email);
public List<Student> getAllStudentRecords();
public Student getStudentDetailsByEmail(String email);
}
