package EmployeeDataManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import EmployeeDataManagement.EmplyeException.EmployeException;
import EmployeeDataManagement.Entity.Employee;
import EmployeeDataManagement.Repository.EmployeeRepository;
import EmployeeDataManagement.services.EmployeeServices;

/* 
 * This are the services implements class for our employee services
 * here we are write the all the services implementation
 * the employee services interface talk with this service implementation class
 * here the service annotation are used to provide some business functionalities
 * autowired is the uses to inject object dependency implicitly
 * */
@Service
public class ServicesImpl implements EmployeeServices{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	/*
	 * Java provides the Optional and its provides methods isPresent to check its in or not
	 * this method are develop by using the Optional provided by java.util
	 *  check the employee id for save employee 
	 * if its have that id its  thrown exception 
	 * 
	 * */
	public String saveEmployee(Employee employee) {
		String message="";
		try {
		Optional<Employee> ExistingEmploye=employeeRepository.findById(employee.getId());
		if(ExistingEmploye.isPresent()) {
			throw new EmployeException("601","Employee already existing in the database","/employeeManagement/addEmployee");
		}
		else {
			employeeRepository.save(employee);
			message="Employe data created successfully";
		}
	
	}
		catch(Exception exception) {
			message=exception.toString();		
		}
		return message;
		}


	
	/*
	 * Here I'm write custom method are with out Optional by check the employee id for save employee 
	 * if its have that id its  thrown exception
	 */
	
	/*
	 * public String saveEmployee(Employee employee) {
		
		String message ="";
		boolean b=false;
		List<Employee> Existingemployes=(List<Employee>) employeeRepository.findAll();
		try {
			for(Employee emps:Existingemployes) {
				if(employee.getId()==emps.getId()) {
					
					throw new EmployeException("601","Employee already existing in the database","/employeeManagement/addEmployee")
				}
				else {
					b=true;
				}
			}
			if(b) {
				employeeRepository.save(employee);
				message="Employe Details saved successfully";
			}
			
		}
		catch(Exception exception) {
			message=exception.toString();		
			}
		
	return message;
	}
	*/
	
	
	/*
	 * this method are useful to send the salary by descending
	 * if two employees have same salary its print names in ascending order
	 * 
	 */
	
	public List<Employee> salbyDesc() {
		return employeeRepository.findAll(Sort.by("Salary").descending().and(Sort.by("Name").ascending()));
	}
	
	/*
	 * this method are useful to set salary by passing salary as Pathvariable
	 * using the id and change the salary by passing the Pathvariable
	 * 
	 */

	
	public ResponseEntity<Employee> updatebysal(int id, double salary) {
		Optional<Employee> ExistingEmployee=employeeRepository.findById(id);
		if(ExistingEmployee.isPresent()) {
			Employee emp=ExistingEmployee.get();
			emp.setSalary(salary);
			return new ResponseEntity<>(employeeRepository.save(emp),HttpStatus.OK);
			}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * this method are useful to getall employees existing in the database
	 * its are using employee Repository (JpaRepository)
	 * 
	 */

	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	/*
	 * this method are useful to get employee by passing salary Pathvariable existing in the database
	 * its are using employee Repository (JpaRepository)
	 * 
	 */

	
	public List<Employee> findbysal(double Salary) {
		
		return employeeRepository.findBySalary(Salary);
	}
	
	/*
	 * this method are useful to delete by id employees existing in the database
	 * its are using employee Repository (JpaRepository)
	 * 
	 */
	
	public String Delbyid(int id) {
		
		 employeeRepository.deleteById(id);
		 return "ID no= "+id+" Deleted Succesfully";
	}
	
	/*
	 * this method are useful to delete all employees existing in the database
	 * its are using employee Repository (JpaRepository)
	 * 
	 */

	
	public String deleteall() {
		employeeRepository.deleteAll();
		return "All EMployees Data Cleared Successfully";
	}

}
