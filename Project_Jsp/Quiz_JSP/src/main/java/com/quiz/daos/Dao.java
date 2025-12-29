package com.quiz.daos;

import java.sql.Connection;

import com.quiz.util.DbUtil;

public class Dao implements AutoCloseable {
	protected Connection con;
	
	public Dao() throws Exception {
		// create new connection
		con = DbUtil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		// close the connection
		if(con != null)
			con.close();
	}
}

