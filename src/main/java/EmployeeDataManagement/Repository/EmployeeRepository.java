package EmployeeDataManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeDataManagement.Entity.Employee;

/*This is the employeeRepository extends for the jpaRepository
 * here we are uses the jparepository interface
 * here adding extra method findbysalary its find employee by giving salary
 * This jpaRepository CrudRepository are provides methods easy
 * */

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	List<Employee> findBySalary(double salary);

}