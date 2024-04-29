package com.proficiency_app.proficiency_api.Professor_Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface ProfessorDisciplinaRepository extends JpaRepository<Professor_Disciplina, ProfessorDisciplinaId> {
    Optional<Professor_Disciplina> findById(ProfessorDisciplinaId id);
}
