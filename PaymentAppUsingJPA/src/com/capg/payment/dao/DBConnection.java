package com.capg.payment.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.capg.payment.exception.*;

public class DBConnection {
	
	private static Connection con;
	
	public static Connection getConnection() throws PaymentException
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String pwd="corp123";
		try {
			if(con==null)
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("class loaded");
			con=DriverManager.getConnection(url, username, pwd);
			System.out.println("Connected");
			}
		}
		catch (SQLException e) 
		{
			throw new PaymentException(e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new PaymentException(e.getMessage());
			
		}
		return con;
	}

}
