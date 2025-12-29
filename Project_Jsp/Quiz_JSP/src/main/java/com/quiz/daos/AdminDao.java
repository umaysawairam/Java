package com.quiz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.quiz.pojos.User;
import com.quiz.util.DbUtil;

public class AdminDao implements AutoCloseable{
	private Connection con =null;
	
	public static int adId;
	
	public AdminDao() throws SQLException{
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean adminLogin(String email , String pass , String role) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE email = ? AND password_hash = ? AND role = ?";
		try (PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, pass);
			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				adId = rs.getInt(1);
				return true;
			}
			rs.close();
			st.close();
		}
		return false;
	}
	
	public List<User> getAllAdmin() throws SQLException{
		List<User> adminList = new ArrayList<>();
		String sql = "SELECT user_id,name,email,password_hash FROM USERS WHERE role = ADMIN";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
				adminList.add(a);
			}
		}
		return adminList;
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}

