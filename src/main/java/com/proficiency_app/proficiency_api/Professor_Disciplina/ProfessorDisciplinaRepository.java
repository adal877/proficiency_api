package com.proficiency_app.proficiency_api.Professor_Disciplina;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorDisciplinaRepository extends JpaRepository<Professor_Disciplina, ProfessorDisciplinaId> {
    Optional<Professor_Disciplina> findById(ProfessorDisciplinaId id);
}
