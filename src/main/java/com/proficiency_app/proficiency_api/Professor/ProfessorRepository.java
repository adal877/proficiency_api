package com.proficiency_app.proficiency_api.Professor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findById(String id);
    List<Professor> findByCode(String code);
    List<Professor> findByIsActive(Boolean is_active);
}
