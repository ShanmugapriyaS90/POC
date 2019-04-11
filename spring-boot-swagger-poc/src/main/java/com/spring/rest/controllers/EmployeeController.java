package com.spring.rest.controllers;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.spring.rest.dao.mappers.EmployeeMapper;
import com.ex.spring.rest.domain.Employee;
import com.ex.spring.rest.exception.EmployeeGenericException;
import com.ex.spring.rest.exception.Error;
import com.ex.spring.util.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/emp")
@Api(value="Employee REST API")
public class EmployeeController {
	
	private EmployeeMapper mapper;
	
	public EmployeeController(EmployeeMapper mapper) {
		this.mapper = mapper;
	}
	@ApiOperation(value="Service to add Employees")
	@PostMapping("/insert")
	public Response addEmployee(@RequestBody Employee employee) {
		Object obj = null;
		try {
			mapper.insert(employee);
			obj = mapper.getEmployeeById(employee.getEmployeeId());
		} catch (EmployeeGenericException e) {
			Error error = new Error(400, e.getCause().getMessage());
			obj = error;
		}
		return Utils.wrapResponse(obj);
	}
	@ApiOperation(value="Service to update Employees",response=Employee.class)
	@PutMapping("/update")
	public Response updateEmployee(@RequestBody Employee employee) {
		Object obj = null;
		Employee emp;
		try {
			emp = mapper.getEmployeeById(employee.getEmployeeId());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			mapper.update(emp);
			obj = mapper.getEmployeeById(employee.getEmployeeId());
		} catch (EmployeeGenericException e) {
			Error error = new Error(400, e.getCause().getMessage());
			obj = error;
		}
		return Utils.wrapResponse(obj);
	}
	@ApiOperation(value="Service to get all Employees",response=List.class)
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = mapper.getAllEmployees();
		} catch (EmployeeGenericException e) {
			e.printStackTrace();
		}
		return empList;
	}
	@ApiOperation(value="Service to get Employees by ID",response=Employee.class)
	@GetMapping("/{employeeID}")
	public Response getEmployeeById(@PathVariable("employeeID") int empID) {
		Object obj = null;
		try {
			obj = mapper.getEmployeeById(empID);
			if (obj == null) {
				Error error = new Error(101, "Data Not Found");
				obj = error;
			}
		} catch(EmployeeGenericException e) {
			Error error = new Error(400, e.getCause().getMessage());
			obj = error;
		}
		return Utils.wrapResponse(obj);
	}
	@ApiOperation(value="Service to delete Employees")
	@DeleteMapping("/delete/{employeeID}")
	public Response removeEmployee(@PathVariable("employeeID") int employeeID) {
		Object obj = null;
		try {
			mapper.deleteEmployeeById(employeeID);
		} catch (EmployeeGenericException e) {
			Error error = new Error(400, e.getCause().getMessage());
			obj = error;
		}
		return Utils.wrapResponse(obj);
	}

}
