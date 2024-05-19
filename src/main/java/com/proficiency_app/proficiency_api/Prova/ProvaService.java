package com.proficiency_app.proficiency_api.Prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Professor.ProfessorService;
import com.proficiency_app.proficiency_api.Questao.Questao;
import com.proficiency_app.proficiency_api.Questao.QuestaoDTO;
import com.proficiency_app.proficiency_api.Questao.QuestaoService;

import jakarta.transaction.Transactional;

@Service
public class ProvaService {
    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private ProfessorService professorService;

    public ProvaService(
            ProvaRepository provaRepository,
            QuestaoService questaoService,
            ProfessorService professorService) {
        this.provaRepository  = provaRepository;
        this.questaoService   = questaoService;
        this.professorService = professorService;
    }

    public Optional<Prova> findById(String id) throws Exception {
        Optional<Prova> prova = provaRepository.findById(id);

        if (prova.isEmpty()) {
            throw new Exception("Data not found");
        }

        return prova;
    }

    public List<Prova> findAll() throws Exception {
        List<Prova> provas = provaRepository.findAll();

        if (provas.isEmpty()) {
            throw new Exception("Data not found");
        }

        return provas;
    }

    public List<Prova> findByProfessorId(String professor_id) {
        return provaRepository.findByProfessorId(professor_id);
    }

    /*
     * public List<Prova> findByQuestaoId(String questao_id) {
     * return provaRepository.findByQuestaoId(questao_id);
     * }
     */

    public List<Prova> saveAll(List<Prova> provas) throws Exception {
        for(Prova prova : provas) {
            Optional<Professor> professor = professorService.findById(
                prova.getProfessor().getId()
            );

            prova.setProfessor(professor.get());
            prova.setRecordType(DataType.QUESTAO);
        }
        return provaRepository.saveAll(provas);
    }

    public Prova save(Prova prova) {
        return provaRepository.save(prova);
    }

    @Transactional
    public Prova criarOuAtualizarProva(ProvaDTO provaRequestDto) {
        Prova prova = new Prova();
        if (provaRequestDto.getId() != null) {
            prova = provaRepository.findById(provaRequestDto.getId())
                    .orElseThrow();
        }

        prova.setName(provaRequestDto.getName());
        prova.setProfessor(provaRequestDto.getProfessor());

        List<Questao> questoes = new ArrayList<>();

        for (QuestaoDTO questao : provaRequestDto.getQuestoes()) {
            questoes.add(
                    questaoService.questaoDtoTOEntity(questao));
        }

        prova.setQuestao(questoes);

        return provaRepository.save(prova);
    }

    @Transactional
    public boolean deletarProva(String id) {
        Prova prova = provaRepository.findById(id).orElse(null);
        if (prova != null) {
            provaRepository.delete(prova);
            return true;
        }
        return false;
    }
}
