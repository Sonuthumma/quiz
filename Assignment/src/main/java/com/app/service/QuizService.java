package com.app.service;



import com.app.model.Question;
import com.app.model.QuizSession;
import com.app.model.UserResponse;
import com.app.repository.QuestionRepository;
import com.app.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;
    
  

    public QuizSession startNewSession(String userName) {
        QuizSession session = new QuizSession();
        session.setUserName(userName);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        Question randomQuestion = questions.get(random.nextInt(questions.size()));

        // Set the correctOption to null
        randomQuestion.setCorrectOption(null);

        return randomQuestion;
    }

    public UserResponse submitAnswer(Long sessionId, Long questionId, String selectedOption) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        UserResponse response = new UserResponse();
        
        response.setQuestionId(questionId);
        response.setSelectedOption(selectedOption);
        
        System.out.print(question.getCorrectOption());
        response.setCorrect(question.getCorrectOption().equals(selectedOption));
        session.getResponses().add(response);

        if (response.isCorrect()) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        quizSessionRepository.save(session);
        return response;
    }

    public QuizSession getSessionSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
}
