package com.quiz.beans;

import com.quiz.daos.StudentDao;
import com.quiz.pojos.User;

public class RegistrationBean {
	private String fname , email , passwd;
	private boolean status;
	
	
	public RegistrationBean() {
		super();
	}

	public RegistrationBean(String fname, String email, String passwd) {
		super();
		this.fname = fname;
		this.email = email;
		this.passwd = passwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void addNewUser() {
		User u = new User(0, fname, email, passwd, null);
		try(StudentDao studentDao = new StudentDao()){
			status = studentDao.studentAdd(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
