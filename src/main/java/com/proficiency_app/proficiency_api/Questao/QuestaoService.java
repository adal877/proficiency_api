package com.proficiency_app.proficiency_api.Questao;

import org.springframework.beans.factory.annotation.Autowired;

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

    public Optional<Questao> findByType(String tipoQuestao) {
        return questaoRepository.findBy
    }
}
