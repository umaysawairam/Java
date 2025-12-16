package com.jdbcPractice;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class jdbcDemo1 {
	private static final String URL = "jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL ,USERNAME ,PASSWORD);
	}
	
	public static void AddStudent() {
		String name = "Shubham";
		String email = "shubham@gmail.com";
		String course = "java";
		String sql = "Insert into student(name , email , course) values(?,?,?)";
		try{
			Connection connection = getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			connection.close();
			insertStatement.close();
			System.out.println("Inserted Succesfully..");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewStudent() {
		String sql = "Select * from student";
		try {
			Connection connection = getConnection();
			PreparedStatement selectStatement = connection.prepareStatement(sql);
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				int rollNo = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				System.out.println("RollNo : " +rollNo + "\nName :" + name + "\nEmail : " + email);
				System.out.println();
			}
			connection.close();
			selectStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void UpdateStudent() {
		String sql = "Update student set course = 'Mern' where rollNo = 94821";
		try {
			Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(sql);
			updateStatement.executeUpdate();
			System.out.println("Updated Succesfully");
			connection.close();
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteStudent() {
		String sql = "Delete from student where rollNo = 94822";
		try {
			Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(sql);
			updateStatement.executeUpdate();
			System.out.println("Deleted Succesfully");
			connection.close();
			updateStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//AddStudent();
		//ViewStudent();
		//UpdateStudent();
		//DeleteStudent();
	}

}
