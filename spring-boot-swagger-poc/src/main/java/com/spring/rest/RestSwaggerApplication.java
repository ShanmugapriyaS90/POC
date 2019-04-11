package com.spring.rest;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ex.spring.rest.domain.Employee;

@MappedTypes(Employee.class)
@MapperScan("com.ex.spring.rest.dao.mappers")
@SpringBootApplication
public class RestSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSwaggerApplication.class, args);
	}
}
