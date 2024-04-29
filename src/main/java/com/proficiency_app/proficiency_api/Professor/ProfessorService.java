package com.proficiency_app.proficiency_api.Professor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorService(
        ProfessorRepository professorRepository
    ) {
        this.professorRepository = professorRepository;
    }

    public Optional<Professor> findById(String id) {
        return professorRepository.findById(id);
    }

    public List<Professor> findByCode(String code) {
        return professorRepository.findByCode(code);
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public List<Professor> saveAll(List<Professor> professors) {
        return professorRepository.saveAll(professors);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}
