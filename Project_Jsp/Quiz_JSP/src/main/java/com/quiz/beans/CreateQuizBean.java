package com.quiz.beans;



import java.io.File;
import java.io.IOException;
import java.util.List;

import com.quiz.daos.QuestionDao;
import com.quiz.daos.QuizDao;
import com.quiz.pojos.Question;
import com.quiz.util.QuestionFileParser;

import jakarta.servlet.http.Part;

public class CreateQuizBean {
	String title;
	Part part;
	int id;
	int quiz_id;
	
	public String getTitle() {
		return title;
	}

	public void setTittle(String title) {
		this.title = title;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public CreateQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void createquiz() {
		File tempFile;
		try {
			tempFile = File.createTempFile("questions", ".txt");
			part.write(tempFile.getAbsolutePath());

			try (QuizDao qzd = new QuizDao()) {
				 quiz_id = qzd.createQuiz(title, id);
				
				List<Question> list = QuestionFileParser.parse(tempFile);
				
			try(QuestionDao questiondao =new QuestionDao()){
				for(Question q : list)
					questiondao.insert(q , title);
			}
			}
			 tempFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

