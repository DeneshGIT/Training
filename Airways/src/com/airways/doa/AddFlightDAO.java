package com.airways.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.airways.model.FormModelclass;

public class AddFlightDAO {
	
	
static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/flightdb";
//Database Credentials
private final String USER = "Denesh1";
private final String PASS = "Alliswell7";
int result1=0;

public int addFlightToDB(FormModelclass Bookingmdl) 
{
	Connection conn=null;
	Statement stmt = null;
	String Flightname = Bookingmdl.getFlightname();
	String Seats = Bookingmdl.getSeats();
	String Fare = Bookingmdl.getFare();
	String Source = Bookingmdl.getSource();
	String Aname = Bookingmdl.getAname();
	
	try
	{
		Class.forName(JDBC_DRIVER);//regestering the driver
	    conn=DriverManager.getConnection(DB_URL,USER,PASS);//getting the connection
		stmt = conn.createStatement();
		
		String query = "INSERT INTO passangerdetails(FlightName,Source,fare,Seats,AircraftName)VALUES('"+Flightname+"','"+Source+"','"+Fare+"','"+Seats+"','"+Aname+"')";
		System.out.println(query);     
	    result1=stmt.executeUpdate(query);
	    System.out.println(result1);
	    
		
		
	}
	catch (Exception E)
	{
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

}
