package com.quiz.beans;

import com.quiz.daos.StudentDao;
import com.quiz.pojos.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	public LoginBean() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void authenticate() {
		try(StudentDao std = new StudentDao()) {
			User u = StudentDao.findUser(email , passwd);
			if(u != null)
				this.user = u;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

