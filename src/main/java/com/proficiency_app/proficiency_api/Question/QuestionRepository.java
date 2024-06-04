package com.proficiency_app.proficiency_api.Question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    Optional<Question> findById(String id);

    List<Question> findAll();
    /*
     * @Query("SELECT q FROM Questao q WHERE Professor.id = :professor_id")
     * List<Questao> findByProfessorId(String professor_id);
     *
     * @Query("SELECT q FROM Questao q WHERE tipo_questao = :tipoQuestao")
     * Optional<Questao> findByTipoQuestao(@Param("tipoQuestao") String
     * tipoQuestao);
     */
}
