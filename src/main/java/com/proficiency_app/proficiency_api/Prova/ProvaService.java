package com.proficiency_app.proficiency_api.Prova;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {
    @Autowired
    private ProvaRepository provaRepository;

    public ProvaService(
        ProvaRepository provaRepository
    ) {
        this.provaRepository = provaRepository;
    }

    public Optional<Prova> findById(String id) {
        return provaRepository.findById(id);
    }

    public List<Prova> findAll() {
        return provaRepository.findAll();
    }

    public List<Prova> findProvaByProfessorId(String professor_id) {
        return provaRepository.findByProfessorId(professor_id);
    }
}
