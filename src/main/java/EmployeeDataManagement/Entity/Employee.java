package EmployeeDataManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*This is Employee entity class its provides employees properties like id name salary gender like that 
 * This are the entity class
 * */

@Entity
@Table(name="Employedata")//change table name in database
public class Employee {
	@Id							//Primary key we are provide id annotation in springboot for declare the primary key
	@Column(name="ID")			//Change column name in database
	private int id;
	
	@Column(name="Name")		//Change column name in database
	private String name;
	
	@Column(name="Salary")		//Change column name in database
	private double salary;
	
	@Column(name="Gender")		//Change column name in database
	private String gender;
	
	/* here  adding constructors with and with out parameters
	 * setters and getters are provides
	 * I'm using toString method here*/

	public Employee() {
		super();
	}
	
	

	public Employee(int id, String name, double salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + "]";
	}
	
	
	
	

}
