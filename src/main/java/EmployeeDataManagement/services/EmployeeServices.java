package EmployeeDataManagement.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import EmployeeDataManagement.Entity.Employee;

/*
 * this are the Employee services interface 
 * here the restcontroller talk with the this interface
 * its hides services implementation and its shows simply
 * the user only talk with the this interface
 */

public interface EmployeeServices {
	
	
	String saveEmployee(Employee employe);
	
	List<Employee> salbyDesc();
	
	ResponseEntity<Employee> updatebysal(int id,double salary);
	
	List<Employee> getAllEmployees();
	
	String Delbyid(int id);
	
	List<Employee> findbysal(double Salary);
	
	String deleteall();
	

}

