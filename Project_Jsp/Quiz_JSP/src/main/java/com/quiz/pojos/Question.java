package com.quiz.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data 

public class Question {
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public int id;
	public int quiz_id;
	public String text;
	public String a;
	public String b;
	public String c;
	public String d;
	public char correct;
}
