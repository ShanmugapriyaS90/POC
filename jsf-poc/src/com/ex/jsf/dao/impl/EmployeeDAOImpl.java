package com.ex.jsf.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.ex.jsf.mbeans.EmployeeBean;
import com.ex.jsf.config.DBConfig;

public class EmployeeDAOImpl {
	
	public static DBConfig dbconfig = new DBConfig();
	public static Connection connObj ;
	  public static Statement stmtObj;
	    public static ResultSet resultSetObj;
	    public static PreparedStatement pstmt;

	 public ArrayList getEmployees() {
	        ArrayList EmployeesList = new ArrayList();  
	        try {
	        	connObj = dbconfig.getConnection();
	        	stmtObj =  connObj.createStatement();
	            resultSetObj = stmtObj.executeQuery("select * from account");    
	            while(resultSetObj.next()) {  
	                EmployeeBean stuObj = new EmployeeBean(); 
	                stuObj.setId(resultSetObj.getInt("account_id"));  
	                stuObj.setName(resultSetObj.getString("name"));  
	                stuObj.setEmail(resultSetObj.getString("email"));  
	                stuObj.setPassword(resultSetObj.getString("password"));  
	                stuObj.setAddress(resultSetObj.getString("address"));  
	                EmployeesList.add(stuObj);  
	            }   
	            System.out.println("Total Records Fetched: " + EmployeesList.size());
	        } catch(Exception sqlException) {
	            sqlException.printStackTrace();
	        } finally {
	        	try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return EmployeesList;
	    }
	 
	 public String saveEmployee(EmployeeBean newEmployeeObj) {
	        int saveResult = 0;
	        String navigationResult = "";
	        try {      
	            pstmt = dbconfig.getConnection().prepareStatement("insert into account (name, email, password, address) values (?, ?, ?, ?)");         
	            pstmt.setString(1, newEmployeeObj.getName());
	            pstmt.setString(2, newEmployeeObj.getEmail());
	            pstmt.setString(3, newEmployeeObj.getPassword());
	            pstmt.setString(4, newEmployeeObj.getAddress());
	            saveResult = pstmt.executeUpdate();
	        } catch(Exception sqlException) {
	            sqlException.printStackTrace();
	        } finally {
	        	try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if(saveResult !=0) {
	            navigationResult = "/faces/employeeList.xhtml?faces-redirect=true";
	        } else {
	            navigationResult = "/faces/newEmployee.xhtml?faces-redirect=true";
	        }
	        return navigationResult;
	    }
	 
	    public String editEmployee(int EmployeeId) {
	        EmployeeBean editRecord = null;
	        System.out.println("editEmployeeRecordInDB() : Employee Id: " + EmployeeId);
	 
	        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 
	        try {
	            resultSetObj = dbconfig.getConnection().createStatement().executeQuery("select * from account where account_id = "+EmployeeId);    
	            if(resultSetObj != null) {
	                resultSetObj.next();
	                editRecord = new EmployeeBean(); 
	                editRecord.setId(resultSetObj.getInt("account_id"));
	                editRecord.setName(resultSetObj.getString("name"));
	                editRecord.setEmail(resultSetObj.getString("email"));
	                editRecord.setAddress(resultSetObj.getString("address"));
	            }
	            sessionMapObj.put("editRecordObj", editRecord);
	            connObj.close();
	        } catch(Exception sqlException) {
	            sqlException.printStackTrace();
	        }
	        return "/editEmployee.xhtml?faces-redirect=true";
	    }
	 
	    public String updateEmployee(EmployeeBean updateEmployeeObj) {
	        try {
	            pstmt = dbconfig.getConnection().prepareStatement("update account set name=?, email=?, address=? where account_id=?");    
	            pstmt.setString(1,updateEmployeeObj.getName());  
	            pstmt.setString(2,updateEmployeeObj.getEmail());  
	            pstmt.setString(3,updateEmployeeObj.getAddress());  
	            pstmt.setInt(4,updateEmployeeObj.getId());  
	            pstmt.executeUpdate();
	            connObj.close();            
	        } catch(Exception sqlException) {
	            sqlException.printStackTrace();
	        }
	        return "/employeeList.xhtml?faces-redirect=true";
	    } 
	 
	    public String deleteEmployee(int EmployeeId){
	        System.out.println("deleteEmployeeRecordInDB() : Employee Id: " + EmployeeId);
	        try {
	            pstmt = dbconfig.getConnection().prepareStatement("delete from account where account_id = "+EmployeeId);  
	            pstmt.executeUpdate();  
	        } catch(Exception sqlException){
	            sqlException.printStackTrace();
	        } finally {
	        	try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return "/employeeList.xhtml?faces-redirect=true";
	    }
}
