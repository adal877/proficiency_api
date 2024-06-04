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
            ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Optional<Professor> findById(String id) throws Exception {
        Optional<Professor> professor = professorRepository.findById(id);

        if (professor.isEmpty()) {
            throw new Exception("Data not found");
        }

        return professor;
    }

    public List<Professor> findByCode(String code) {
        return professorRepository.findByCode(code);
    }

    public List<Professor> findAll() throws Exception {
        List<Professor> professors = professorRepository.findAll();

        if (professors.isEmpty()) {
            throw new Exception("Data not found");
        }

        return professors;
    }

    public List<Professor> findByIsActive(Boolean isActive) {
        return professorRepository.findByIsActive(isActive);
    }

    public List<Professor> saveAll(List<Professor> professors) {
        return professorRepository.saveAll(professors);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteById(String id) {
        professorRepository.deleteById(id);
    }

    public void fakeDeleteById(String id) {
        Professor professor = professorRepository.findById(id).get();
        professor.setIsActive(false);

        professorRepository.save(professor);
    }

}
