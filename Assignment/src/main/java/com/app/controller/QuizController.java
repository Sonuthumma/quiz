package com.app.controller;


import com.app.model.Question;
import com.app.model.QuizSession;
import com.app.model.UserResponse;
import com.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestParam String userName) {
        return quizService.startNewSession(userName);
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/answer")
    public UserResponse submitAnswer(@RequestParam Long sessionId,
                                    @RequestParam Long questionId,
                                    @RequestParam String selectedOption) {
        return quizService.submitAnswer(sessionId, questionId, selectedOption);
    }

    @GetMapping("/summary")
    public QuizSession getSummary(@RequestParam Long sessionId) {
        return quizService.getSessionSummary(sessionId);
    }
}
