package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.QuizSession;

@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {}
