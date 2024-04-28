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

    public Optional<Resposta> findById(String id) {
        return respostaRepository.findById(id);
    }

    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }
}
