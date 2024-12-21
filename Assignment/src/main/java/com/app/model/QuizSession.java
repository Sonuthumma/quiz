package com.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="quiz_session")
public class QuizSession {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps to the "id" column in the table
    private Long id;

    @Column(name = "user_name", nullable = false) // Custom column name
    private String userName;

    @Column(name = "correct_answers", nullable = false) // Default to 0 and cannot be null
    private int correctAnswers = 0;

    @Column(name = "incorrect_answers", nullable = false) // Default to 0 and cannot be null
    private int incorrectAnswers = 0;

    
    

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserResponse> responses = new ArrayList<>();



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getCorrectAnswers() {
		return correctAnswers;
	}



	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}



	public int getIncorrectAnswers() {
		return incorrectAnswers;
	}



	public void setIncorrectAnswers(int incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}



	public List<UserResponse> getResponses() {
		return responses;
	}



	public void setResponses(List<UserResponse> responses) {
		this.responses = responses;
	}

    

	public QuizSession() {
		super();
	}



	public QuizSession(Long id, String userName, int correctAnswers, int incorrectAnswers,
			List<UserResponse> responses) {
		super();
		this.id = id;
		this.userName = userName;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.responses = responses;
	}
    
    
    
    
}