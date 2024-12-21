package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity

public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long questionId;
    private String selectedOption;
    private boolean isCorrect;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	public UserResponse() {
		super();
	}
	public UserResponse(Long id, Long questionId, String selectedOption, boolean isCorrect) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.selectedOption = selectedOption;
		this.isCorrect = isCorrect;
	}
	public UserResponse(Long questionId, String selectedOption) {
		this.questionId=questionId;
		this.selectedOption=selectedOption;
		
	}
    
    
}