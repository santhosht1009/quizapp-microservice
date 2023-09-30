package com.example.questionservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.questionservice.dto.Question;
import com.example.questionservice.dto.QuestionWrapper;
import com.example.questionservice.dto.Response;
import com.example.questionservice.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @Autowired
    Environment environment;
    
    
@GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/addquestion")
public ResponseEntity<String> addQuestion(@RequestBody Question question){

    return questionService.addQuestion(question);
}

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQiuz
    (@RequestParam String categoryName,@RequestParam Integer numQuestions ){
    	//System.out.println(environment.getProperty("local.server.port")); 
    	//to check which port is using if we use instances
    	
    	
    	return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }
    
    @PostMapping("/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
    	return questionService.getQuestionsFromId(questionIds);
    }
    
    @PostMapping("/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
    	return questionService.getScore(responses);
    }
    

}
