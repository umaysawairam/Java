package com.quiz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quiz.pojos.Attempts;
import com.quiz.pojos.Question;
import com.quiz.util.DbUtil;

public class AttemptDao implements AutoCloseable{
	public Connection con = null;

	public AttemptDao() throws SQLException{
		try {
			con = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Question> getQuestion(int qid) throws SQLException{
		List<Question> queList = new ArrayList<>();
		String sql = "SELECT question_text, option_a, option_b, option_c, option_d FROM questions WHERE quiz_id = ?";
		try(PreparedStatement pt = con.prepareStatement(sql)){
			pt.setInt(1, qid);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				Question q = new Question();
				q.setText(rs.getString(1));
				q.setA(rs.getString(2));
				q.setB(rs.getString(3));
				q.setC(rs.getString(4));
				q.setD(rs.getString(5));
				queList.add(q);
			}
		}
		return queList;
	}

	public void insertAttempt(int qid, int stuId, int score, int totalQue) throws SQLException {
		String sql = "INSERT INTO quiz_attempts (quiz_id, user_id, final_score, total_questions) VALUES (?, ?, ?, ?)";
		try(PreparedStatement pit = con.prepareStatement(sql)) {
			pit.setInt(1, qid);
			pit.setInt(2, stuId);
			pit.setInt(3, score);
			pit.setInt(4, totalQue);
			
			pit.executeUpdate();
			pit.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Attempts> displayScore() throws SQLException {
		List<Attempts> atmList = new ArrayList<>();
		String sql = "SELECT * FROM quiz_attempts";
		try(PreparedStatement dt = con.prepareStatement(sql)) {
			ResultSet rs = dt.executeQuery();
			while(rs.next()) {
				Attempts at = new Attempts();
				at.setId(rs.getInt(1));
				at.setQuiz_id(rs.getInt(2));
				at.setStudent_id(rs.getInt(3));
				at.setScore(rs.getInt(4));
				at.setTotal(rs.getInt(5));
				atmList.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atmList;
	}
	
	public List<Attempts> viewScore(int uid) throws SQLException {
		List<Attempts> atmList = new ArrayList<>();
		String sql = "SELECT * FROM quiz_attempts WHERE user_id = ?";
		try(PreparedStatement dt = con.prepareStatement(sql)) {
			dt.setInt(1, uid);
			ResultSet rs = dt.executeQuery();
			while(rs.next()) {
				Attempts at = new Attempts();
				at.setId(rs.getInt(1));
				at.setQuiz_id(rs.getInt(2));
				at.setScore(rs.getInt(4));
				at.setTotal(rs.getInt(5));
				atmList.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atmList;
	}
	
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}

