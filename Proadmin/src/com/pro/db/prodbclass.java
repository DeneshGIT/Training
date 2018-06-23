package com.pro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pro.model.promodelclass;

public class prodbclass {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/flightdb";
	//Database Credentials
	private final String USER = "Denesh1";
	private final String PASS = "Alliswell7";
	int result1=0;
	int result2=0;
	
	
	public int addprotodb(promodelclass modelobj)
	{
		
		Connection conn=null;
		Statement stmt = null;
		String empid = modelobj.getEmpID();
		String empname = modelobj.getEmpName();
		String deptcode = modelobj.getDeptCode();
		String doj = modelobj.getDOJ();
		String Password = modelobj.getPassword();
		//String ConfirmPassword = modelobj.getConfirmPassword();
		
		try {
			Class.forName(JDBC_DRIVER);//regestering the driver
		    conn=DriverManager.getConnection(DB_URL,USER,PASS);//getting the connection
			stmt = conn.createStatement();
			String query = "INSERT INTO producttable(empid,empname,deptcode,doj,Password)VALUES('"+empid+"','"+empname+"','"+deptcode+"','"+doj+"','"+Password+"')";
			System.out.println(query);     
		    result1=stmt.executeUpdate(query);
		    System.out.println("inserting result="+result1);
		    System.out.println("DB Insert Done");
			
			
			
		} catch (Exception E) {
			// TODO: handle exception
			System.out.println(E.getMessage());
		}
		finally 
		{try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
			return result1;
			

		}
	
	
	
	
	public int getfromdb(promodelclass modelobj)
	{
		
		Connection conn=null;
		Statement stmt = null;
		
		
		try {
			Class.forName(JDBC_DRIVER);//regestering the driver
		    conn=DriverManager.getConnection(DB_URL,USER,PASS);//getting the connection
			stmt = conn.createStatement();
			String Uname=modelobj.getUsername();
			String Upass = modelobj.getUPassword();
			String query = "SELECT empname FROM producttable WHERE empid='"+Uname+"' AND Password='"+Upass+"'";
			System.out.println(query);     
		    ResultSet result21=stmt.executeQuery(query);
		    if  (result21.next()) {
		        String em = result21.getString("empname");
		        System.out.println("Result from select query="+em);
		        result2 = 1;
		       
		    }
		    
		   
			
			
			
		} catch (Exception E) {
			// TODO: handle exception
			System.out.println(E.getMessage());
		}
		finally 
		{try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		 return result2;
			

		}
	
	
	
	
	public List<promodelclass> fetchfromdb(promodelclass modelobj)
	{
		
		Connection conn=null;
		Statement stmt = null;
		List<promodelclass> denesh = new ArrayList<promodelclass>();
		
		try {
			Class.forName(JDBC_DRIVER);//regestering the driver
		    conn=DriverManager.getConnection(DB_URL,USER,PASS);//getting the connection
			stmt = conn.createStatement();
			String Uname=modelobj.getUsername();
			String Upass = modelobj.getUPassword();
			String query = "SELECT empid,empname,deptcode,doj FROM producttable";
			System.out.println(query);     
		    ResultSet result22=stmt.executeQuery(query);
		    promodelclass listobj=null;
		    while  (result22.next()) {
		    	listobj = new promodelclass();
		    	listobj.setEmpID(result22.getString("empid"));
		    	listobj.setEmpName(result22.getString("empname"));
		    	listobj.setDeptCode(result22.getString("deptcode"));
		    	listobj.setDOJ(result22.getString("doj"));
		    	denesh.add(listobj);  
		       
		    }
		    
		   
			
			
			
		} catch (Exception E) {
			// TODO: handle exception
			System.out.println(E.getMessage());
		}
		finally 
		{try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		 return denesh;
			

		}
		
		
	}


	
	
	
	
	
	
	


