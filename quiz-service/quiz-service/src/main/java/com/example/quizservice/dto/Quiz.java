package com.example.quizservice.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer  id;
  private String title;

  @ElementCollection
  private  List<Integer> questionids;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public List<Integer> getQuestionids() {
	return questionids;
}

public void setQuestionids(List<Integer> questionids) {
	this.questionids = questionids;
}


  

}
