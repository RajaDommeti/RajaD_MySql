package com.gl.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	Connection con=null;
	String user = "root";
	String url = "jdbc:mysql://localhost:3306/GL";
	String password = "1408";
	
	public Connection getMyConnections()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		return con;
	}
}
