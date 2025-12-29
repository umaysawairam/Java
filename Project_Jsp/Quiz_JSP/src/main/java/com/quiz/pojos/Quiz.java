package com.quiz.pojos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data 

public class Quiz {
	public Quiz() {
		// TODO Auto-generated constructor stub
	}
	public int id;
	public String title;
	public Integer creater_id;
}
