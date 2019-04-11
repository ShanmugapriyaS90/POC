package com.ex.spring.rest.domain;

import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

//@Entity
//@Table(name="Employee")
public class Employee {
	//@Id
	//@Column(name="employeeId")
	private int employeeId;
	
	//@Column(name="firstName")
	private String firstName;
	
	//@Column(name="lastName")
	private String lastName;
	
	//@Column(name="designation")
	private String designation;
	
	//private Employee supervisor;
	//@Column(name="email")
	private String email;
	
	//@Column(name="mobile")
	private String mobile;
	
	//@Column(name="address")
	private String address;
	
	//@Column(name="dateofbirth")
	private Date dateofbirth;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/*public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateofbirth=" + dateofbirth + "]";
	}

}
