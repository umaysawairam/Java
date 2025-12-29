package com.quiz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quiz.pojos.User;
import com.quiz.util.DbUtil;

public class StudentDao implements AutoCloseable {
	public static User currentuser = null;
	private static Connection con =null;
	
	public static int stuId;
	
	public StudentDao() throws SQLException{
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean studentLogin(String email , String pass , String role) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE email = ? AND password_hash = ? AND role = ?";
		try (PreparedStatement st= con.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, pass);
			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				stuId = rs.getInt(1);
				return true;
			}
			rs.close();
			st.close();
		}
		return false;
	}
	
	public static User findUser(String email,String password) throws SQLException {
		String sql = "select * from users where email=? and password_hash=?";
		try(PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				currentuser= new User();
				currentuser.setId(rs.getInt(1));
				currentuser.setName(rs.getString(2));
				currentuser.setEmail(email);
				currentuser.setPassword(password);
				currentuser.setRole(rs.getString(5));
				
				return currentuser;
			}
			return null;
		}}
	
	public void studentRegister(String name ,String email , String pass , String role) throws SQLException {
		String sql = "INSERT INTO USERS(name , email , password_hash , role) VALUES(?,?,?,?)";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, pass);
			pt.setString(4, role);
			pt.executeUpdate();
			pt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean studentAdd(User user) throws SQLException {
		
		if(findUser(user.getEmail(), user.getPassword())!=null) return false;
		else {
			
		
		String sql = "insert into users (name,email,password_hash) values(?,?,?)";
		try(PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			 stmt.executeUpdate();
			
		}
		return true;
		}
			
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}

