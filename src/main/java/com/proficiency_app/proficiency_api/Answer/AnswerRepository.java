package com.proficiency_app.proficiency_api.Answer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, String> {
    Optional<Answer> findById(String id);
    List<Answer> findAll();
}
