package com.gl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gl.connection.MyConnection;
import com.gl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	Employee employee;
	MyConnection mycon;


	public EmployeeDaoImpl() {
		employee=new Employee();
		mycon=new MyConnection();
	}


	@Override
	public void insertRecords(Employee employee) {
		con = mycon.getMyConnections();
		try {
			String insertQuery="INSERT INTO employee (Id, Name, Email_Id, Phone_Number)VALUES (?, ?, ?, ?)";
			pstmt=con.prepareStatement(insertQuery);

			pstmt.setInt(1,employee.getId());
			pstmt.setString(2,employee.getName());
			pstmt.setString(3,employee.getEmail_id());
			pstmt.setString(4,employee.getPhone_no());
			int status=pstmt.executeUpdate();
			if(status>0) {
				System.out.println("employee details  inserted successfully in database");
			}else {
				System.out.println("employee details not inserted into database");
			}
		}catch(SQLException e) {
			e.getMessage();
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}




	@Override
	public void modifyEmailColumn() {
		try {
			con = mycon.getMyConnections();
			String modifyQuery="alter table employee modify Email_Id varchar(30) NOT NULL";
			stmt=con.createStatement();
			stmt.executeUpdate(modifyQuery);
			System.out.println("Modification done...");
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	

	@Override
	public void updateEmployee(int id, String newName, String newPhnNum) {
		try {
			con = mycon.getMyConnections();
			String updateQuery="update employee set Name=?,Phone_Number=? where Id=?";
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setString(1, newName);
			pstmt.setString(2, newPhnNum);
			pstmt.setInt(3, id);
			int status=pstmt.executeUpdate();
			if(status>0) {
				System.out.println("employee details  updated successfully in database");
			}else {
				System.out.println("employee details not updated into database");
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}

	}


	@Override
	public void deleteEmployee() {
		try {
		con=mycon.getMyConnections();
		String deleteQuery="delete from employee where Id in(?,?)";
		pstmt=con.prepareStatement(deleteQuery);
		pstmt.setInt(1,3);
		pstmt.setInt(2,4);
		int status=pstmt.executeUpdate();
		if(status>0) {
			System.out.println("employee details  deleted  in database");
		}else {
			System.out.println("employee details not deleted into database");
		}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void removeAllRecords() {
		try {
		con=mycon.getMyConnections();
		String deleteQuery="delete from employee";
		pstmt=con.prepareStatement(deleteQuery);
		pstmt.executeUpdate();
		System.out.println("records deleted successfully...");
		}catch(SQLException e) {
			e.printStackTrace();
		}


	}


	@Override
	public void display() {
		con = mycon.getMyConnections();
		try {
			String selectQuery="select * from employee";
			pstmt=con.prepareStatement(selectQuery);
			rs=pstmt.executeQuery();
			System.out.println("Id\tName\tEmail_Id\tPhone_Number");
			while(rs.next()) {
				int id=rs.getInt("Id");
				String name=rs.getString("Name");
				String Email_Id=rs.getString("Email_Id");
				String Phone_Number=rs.getString("Phone_Number");
				System.out.println(id+"\t"+name+"\t"+Email_Id+"\t"+Phone_Number);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


}
