package com.proficiency_app.proficiency_api.Resposta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
