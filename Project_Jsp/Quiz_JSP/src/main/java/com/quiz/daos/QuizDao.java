package com.quiz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.quiz.pojos.*;
import com.quiz.util.DbUtil;

public class QuizDao implements AutoCloseable {
private Connection con = null;
	
	public QuizDao() throws SQLException {
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//DISPLAY QUIZ
	public List<Quiz> getQuizList() throws SQLException {
		List<Quiz> quizList = new ArrayList<>();
		String sql = "SELECT quiz_id, title, creator_id FROM quizzes";
		try (PreparedStatement selectStatement = con.prepareStatement(sql)) {
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt(1));
				quiz.setTitle(rs.getString(2));
				quiz.setCreater_id(rs.getInt(3));
				quizList.add(quiz);
			}
		}
		return quizList;
	}
	//CREATE QUIZ
	public int createQuiz(String title, int creatorId) throws SQLException {
		int quizId = -1;
		String sql = "INSERT INTO quizzes (title, creator_id) VALUES (?, ?)";
		try (PreparedStatement insertStatement = con.prepareStatement(sql)) {
			insertStatement.setString(1, title);
			insertStatement.setInt(2, creatorId);
			insertStatement.executeUpdate();
		}
		String sql2 = "select quiz_id from quizzes";
		try(PreparedStatement stmt = con.prepareStatement(sql2)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				quizId=rs.getInt(1);
			}
		}
				
		return quizId;
				
	}
	//REMOVE QUIZ
	public void removeQuiz(int qId) throws SQLException{
		String sql = "DELETE FROM quizzes WHERE quiz_id = ?";
		try(PreparedStatement deleteStatement = con.prepareStatement(sql)){
			deleteStatement.setInt(1, qId);
			deleteStatement.executeUpdate();
		}
	}
	//INSERT QUIZ AND USING FILE ADDED HERE
	public int insert(Quiz q) throws SQLException {
		String sql = "INSERT INTO quizzes (title, creator_id) VALUES (?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, q.getTitle());
			ps.setInt(2, q.getCreater_id());
			ps.executeUpdate();
		}
		return AdminDao.adId;
	}
	
	//AUTOCLOSEABLE
	public void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}

