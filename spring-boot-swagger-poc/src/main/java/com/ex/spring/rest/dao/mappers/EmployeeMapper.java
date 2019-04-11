package com.ex.spring.rest.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ex.spring.rest.domain.Employee;
import com.ex.spring.rest.exception.EmployeeGenericException;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee where firstName = #{empName}")
	Employee findEmployeeByName(@Param("empName") String empName) throws EmployeeGenericException;
	
	@Select("select * from employee")
	public List<Employee> getAllEmployees() throws EmployeeGenericException;

	@Select("select * from employee where employeeId = #{id}")
	public Employee getEmployeeById(long id) throws EmployeeGenericException;

	@Delete("DELETE FROM employee where employeeId = #{id}")
	public int deleteEmployeeById(long id) throws EmployeeGenericException;

	@Insert("INSERT INTO employee(employeeId, firstName, lastName, designation,email,mobile,address,dateofbirth) VALUES (#{employeeId}, #{firstName}, #{lastName},#{designation},#{email},#{mobile},#{address},#{dateofbirth})")
	public int insert(Employee emp) throws EmployeeGenericException;

	@Update("Update employee set firstName=#{firstName} ,lastName=#{lastName} where employeeId=#{employeeId}")
	public int update(Employee emp) throws EmployeeGenericException;
}
