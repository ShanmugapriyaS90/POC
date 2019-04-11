package com.ex.jsf.domain;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


public class Employee {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private int number;
	
	private String fullName;
	
	public Employee() {
		
	}
	
	/*public String post() {
		return "response";
	}
	
	public String getName() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String,String> params = context.getExternalContext().getRequestParameterMap();
		this.setFullName(params.get("firstName") + params.get("lastName"));
		return "response";
	}
	
	public void actionListenerMethod(ActionEvent event) {
		Map<String,Object> eventAtt = event.getComponent().getAttributes();
		System.out.println(eventAtt.get("attr").toString());
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
