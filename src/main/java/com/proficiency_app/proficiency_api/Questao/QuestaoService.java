package com.proficiency_app.proficiency_api.Questao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Prova.Prova;
import com.proficiency_app.proficiency_api.Resposta.Resposta;
import com.proficiency_app.proficiency_api.Resposta.RespostaService;

import jakarta.transaction.Transactional;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private RespostaService respostaService;

    public QuestaoService(
        QuestaoRepository questaoRepository,
        RespostaService respostaService
    ) {
        this.questaoRepository = questaoRepository;
        this.respostaService   = respostaService;
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

    @Transactional
    public List<Questao> criarOuAtualizarQuestoes(List<QuestaoDTO> questoesDto, Prova prova) throws NotFoundException {
        List<Questao> questoesSalvas = new ArrayList<>();

        for (QuestaoDTO questaoDto : questoesDto) {
            Questao questao = new Questao();
            if (questaoDto.getId() != null) {
                questao = questaoRepository
                    .findById(
                        questaoDto.getId()
                    )
                    .orElseThrow(() ->
                        new NotFoundException()
                    );
            }

            questao.setTexto(questaoDto.getTexto());
            questao.setTipoQuestao(questaoDto.getTipoQuestao());
            questao.setProva(prova);
            questao.setProfessor(prova.getProfessor()); // Associar professor da prova à questão

            List<Resposta> respostasSalvas = respostaService.criarOuAtualizarRespostas(questaoDto.getRespostas(), questao);
            questao.setRespostas(respostasSalvas);

            questoesSalvas.add(questaoRepository.save(questao));
        }

        return questoesSalvas;
    }

    public Questao questaoDtoTOEntity(QuestaoDTO questaoDTO) {
        Questao questao = new Questao();
        questao.setId(questaoDTO.getId());
        questao.setTexto(questaoDTO.getTexto());
        questao.setTipoQuestao(questaoDTO.getTipoQuestao());
        questao.setRespostas(
            questaoDTO.getRespostas()
            .forEach()
        );
        return questao;
    }

    /*
    public Optional<Questao> findByType(String tipoQuestao) {
        return questaoRepository.findByTipoQuestao(tipoQuestao);
    }
    */
}
