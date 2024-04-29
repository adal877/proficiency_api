package com.proficiency_app.proficiency_api.Questao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestaoRepository extends JpaRepository<Questao, String> {
    Optional<Questao> findById(String id);
    List<Questao> findAll();
    /*
    @Query("SELECT q FROM Questao q WHERE Professor.id = :professor_id")
    List<Questao> findByProfessorId(String professor_id);
    @Query("SELECT q FROM Questao q WHERE tipo_questao = :tipoQuestao")
    Optional<Questao> findByTipoQuestao(@Param("tipoQuestao") String tipoQuestao);
    */
}
