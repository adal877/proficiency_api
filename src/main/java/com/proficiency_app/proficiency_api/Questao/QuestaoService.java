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

    public Optional<Questao> findById(String id) {
        return questaoRepository.findById(id);
    }

    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    /*
    public Optional<Questao> findByType(String tipoQuestao) {
        return questaoRepository.findByTipoQuestao(tipoQuestao);
    }
    */
}
