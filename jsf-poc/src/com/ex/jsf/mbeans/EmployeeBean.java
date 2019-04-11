package com.ex.jsf.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ex.jsf.dao.impl.EmployeeDAOImpl;
import com.ex.jsf.domain.Department;
import com.ex.jsf.domain.Employee;
import com.sun.istack.internal.NotNull;

@ManagedBean
@RequestScoped
public class EmployeeBean {

	private int id;  
	@NotNull
    private String name;  
    private String email;  
    private String password;  
    private String address;
    public ArrayList employeesList;
    
    public EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
    
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@PostConstruct
    public void init() {
		employeesList = empDAO.getEmployees();
    }
 
    public ArrayList employeesList() {
        return employeesList;
    }
    
    public String saveEmployee(EmployeeBean emp) {
        return empDAO.saveEmployee(emp);
    }
 
	public String deleteemployeeRecord(int id) {
		return empDAO.deleteEmployee(id);
	}
	
	public String editemployeeRecord(int id) {
		return empDAO.editEmployee(id);
	}
	
	public String updateEmployee(EmployeeBean emp) {
		return empDAO.updateEmployee(emp);
	}
}
