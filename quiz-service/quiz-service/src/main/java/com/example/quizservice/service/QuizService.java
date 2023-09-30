package com.example.quizservice.service;

import com.example.quizservice.dto.QuestionWrapper;
import com.example.quizservice.dto.Quiz;
import com.example.quizservice.dto.Response;
import com.example.quizservice.feign.QuizInterface;
import com.example.quizservice.repository.QuizDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class QuizService {
    @Autowired
    QuizDao quizDao;
@Autowired
QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions=quizInterface.getQuestionsForQiuz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionids(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
Quiz quiz=quizDao.findById(id).get();
List<Integer> questionIds=quiz.getQuestionids();
        ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score=quizInterface.getScore(responses);
        
        return score;
    }
}
