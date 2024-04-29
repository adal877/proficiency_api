package com.proficiency_app.proficiency_api.Disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Professor.ProfessorService;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ProfessorService professorService;

    public DisciplinaService(
        DisciplinaRepository disciplinaRepository,
        ProfessorService professorService
    ) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorService = professorService;
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

    public List<Disciplina> findByProfessorId(Professor professor) {
        return disciplinaRepository.findByProfessor(
            professorService.findById(
                professor.getId()
            )
        );
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public List<Disciplina> saveDisciplinas(List<Disciplina> disciplinas) {
        List<Disciplina> disciplinasSaved = new ArrayList<Disciplina>();

        for(Disciplina disciplina : disciplinas) {
            Optional<Professor> professor = professorService.findById(disciplina.getProfessor().getId());
            disciplina.setProfessor(professor.get());

            disciplinasSaved.add(
                disciplinaRepository.save(disciplina)
            );
        }
        return disciplinaRepository.saveAll(
            disciplinas
        );
    }
}
