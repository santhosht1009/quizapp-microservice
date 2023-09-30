package com.example.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quizservice.dto.QuestionWrapper;
import com.example.quizservice.dto.Response;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	 @GetMapping("/question/generate")
	    public ResponseEntity<List<Integer>> getQuestionsForQiuz
	    (@RequestParam String categoryName,@RequestParam Integer numQuestions );
	    
	    @PostMapping("/question/getquestions")
	    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	    
	    @PostMapping("/question/getscore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	
}
