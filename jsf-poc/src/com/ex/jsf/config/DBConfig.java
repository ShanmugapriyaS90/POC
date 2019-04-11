package com.ex.jsf.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
 
import javax.faces.context.FacesContext;
 
import com.ex.jsf.mbeans.EmployeeBean;

public class DBConfig {
	
	 public static Connection connObj;
	 
	    public static Connection getConnection(){  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");     
	            String db_url ="jdbc:mysql://localhost:3306/ems",
	                    db_userName = "root",
	                    db_password = "root";
	            connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
	        } catch(Exception sqlException) {  
	            sqlException.printStackTrace();
	        }  
	        return connObj;
	    }
	 

}
