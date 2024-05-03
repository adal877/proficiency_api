package com.proficiency_app.proficiency_api.Questao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;

    public QuestaoService(
        QuestaoRepository questaoRepository
    ) {
        this.questaoRepository = questaoRepository;
    }

    public Optional<Questao> findById(String id) throws Exception {
        Optional<Questao> questao = questaoRepository.findById(id);

        if(questao.isEmpty()) {
            throw new Exception("Data not found");
        }

        return questao;
    }

    public List<Questao> findAll() throws Exception {
        List<Questao> questoes = questaoRepository.findAll();

        if(questoes.isEmpty()) {
            throw new Exception("Data not found");
        }

        return questoes;
    }

    public List<Questao> saveAll(List<Questao> questoes) {
        return questaoRepository.saveAll(questoes);
    }

    public Questao save(Questao questao) {
        return questaoRepository.save(questao);
    }
    /*
    public Optional<Questao> findByType(String tipoQuestao) {
        return questaoRepository.findByTipoQuestao(tipoQuestao);
    }
    */
}
