package EmployeeDataManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EmployeeDataManagement.Entity.Employee;
import EmployeeDataManagement.services.EmployeeServices;

/* This is the Controller this are using springboot controls classes methods 
 * This will talk with only employee services interface
 * This are the main for springboot for controlling 
 * its define the Restful web services
 * the Autowired are uses to inject the object dependency its work with reference only
 * 
 * */

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServices services;
	
	@PostMapping("/employeeManagement/addEmployee")
	public String addEmploye(@RequestBody Employee employee) {
		return services.saveEmployee(employee);
	}
	
	@GetMapping("/employeeManagement/salbyDescNamesbyAsc")
	public List<Employee> salbydescNamesAsc(){
		return services.salbyDesc();
	}
	@GetMapping("/employeeManagement/updatesalarybyid-sal/{id}/{salary}")
	public ResponseEntity<Employee> updatesalbyid(@PathVariable int id,@PathVariable double salary){
		return services.updatebysal(id, salary);
	}
	
	@GetMapping("/employeeManagement/allEmployees")
	public List<Employee> GetAllEmployees(){
		return services.getAllEmployees();
		}
	
	@DeleteMapping("/employeeManagement/delete/{id}")
	public String DeleteEmployeebyid(@PathVariable int id) {
		return services.Delbyid(id);
	}
	@GetMapping("/employeeManagement/bysalary/{salary}")
	public List<Employee> GetEmpBySal(@PathVariable double salary){
		return services.findbysal(salary);
		}
	@DeleteMapping("/employeeManagement/deleteAll")
	public String deleteAll() {
		return services.deleteall();
	}
	
	

}

