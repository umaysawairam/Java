package com.quiz.pojos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data 

public class Attempts {
	public int id;
	public int quiz_id;
	public int student_id;
	public int score;
	public int total;
	public LocalDateTime attemptTime;
	
	public Attempts() {
		super();
	}
	
	
	
}
