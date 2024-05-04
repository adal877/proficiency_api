package com.proficiency_app.proficiency_api.Resposta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Questao.Questao;

import jakarta.transaction.Transactional;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    public RespostaService(
        RespostaRepository respostaRepository
    ) {
        this.respostaRepository = respostaRepository;
    }

    public Optional<Resposta> findById(String id) throws Exception {
        Optional<Resposta> resposta = respostaRepository.findById(id);

        if(resposta.isEmpty()) {
            throw new Exception("Data not found");
        }

        return resposta;
    }

    public List<Resposta> findAll() throws Exception {
        List<Resposta> respostas = respostaRepository.findAll();

        if(respostas.isEmpty()) {
            throw new Exception("Data not found");
        }

        return respostas;
    }

    public List<Resposta> saveAll(List<Resposta> respostas) {
        return respostaRepository.saveAll(respostas);
    }

    public Resposta save(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    @Transactional
    public List<Resposta> criarOuAtualizarRespostas(List<RespostaDTO> respostasDto, Questao questao) throws NotFoundException {
        List<Resposta> respostasSalvas = new ArrayList<>();

        for (RespostaDTO respostaDto : respostasDto) {
            Resposta resposta = new Resposta();
            if (respostaDto.getId() != null) {
                resposta = respostaRepository.findById(
                    respostaDto.getId()
                )
                .orElseThrow(() ->
                    new NotFoundException());
            }

            resposta.setTexto(respostaDto.getTexto());
            resposta.setCorreta(respostaDto.getCorreta());
            resposta.setTipoResposta(respostaDto.getTipoResposta());
            resposta.setQuestao(questao);

            respostasSalvas.add(respostaRepository.save(resposta));
        }

        return respostasSalvas;
    }

    public Resposta respostaDtoToEntity(RespostaDTO respostaDTO) {
        Resposta resposta = new Resposta();

        resposta.setId(resposta.getId());
        resposta.setTexto(respostaDTO.getTexto());
        resposta.setCorreta(respostaDTO.getCorreta());
        resposta.setTipoResposta(respostaDTO.getTipoResposta());

        return resposta;
    }
}
