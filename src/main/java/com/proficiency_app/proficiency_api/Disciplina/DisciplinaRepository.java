package com.proficiency_app.proficiency_api.Disciplina;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proficiency_app.proficiency_api.Professor.Professor;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
    List<Disciplina> findByCode(String code);

    List<Disciplina> findByName(String name);

    Optional<Disciplina> findById(String id);

    List<Disciplina> findByProfessor(Optional<Professor> optional);
}
