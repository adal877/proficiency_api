package com.proficiency_app.proficiency_api.PalavraChave;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.proficiency_app.proficiency_api.Questao.Questao;
import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;





public interface PalavraChaveRepository extends JpaRepository<PalavraChave, String> {
    Optional<PalavraChave> findById(String id);
    List<PalavraChave> findByQuestao(Questao questao);
    List<PalavraChave> findByDisciplina(Disciplina disciplina);
    List<PalavraChave> findByProfessor(Professor professor);
}
