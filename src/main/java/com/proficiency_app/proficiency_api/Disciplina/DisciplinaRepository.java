package com.proficiency_app.proficiency_api.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
    List<Disciplina> findByCode(String code);
    List<Disciplina> findByName(String name);
    Optional<Disciplina> findById(String id);
}
