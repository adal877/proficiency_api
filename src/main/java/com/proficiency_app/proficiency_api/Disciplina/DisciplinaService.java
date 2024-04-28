package com.proficiency_app.proficiency_api.Disciplina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaService(
        DisciplinaRepository disciplinaRepository
    ) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findByCode(String code) {
        return disciplinaRepository.findByCode(code);
    }

    public List<Disciplina> findByName(String name) {
        return disciplinaRepository.findByName(name);
    }

    public Optional<Disciplina> findById(String id) {
        return disciplinaRepository.findById(id);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }
}
