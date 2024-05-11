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
            ProfessorService professorService) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorService = professorService;
    }

    public List<Disciplina> findByCode(String code) {
        return disciplinaRepository.findByCode(code);
    }

    public List<Disciplina> findByName(String name) {
        return disciplinaRepository.findByName(name);
    }

    public Optional<Disciplina> findById(String id) throws Exception {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            throw new Exception("Data not found");
        }

        return disciplina;
    }

    public List<Disciplina> findByProfessorId(Professor professor) throws Exception {
        return disciplinaRepository.findByProfessor(
                professorService.findById(
                        professor.getId()));
    }

    public List<Disciplina> findAll() throws Exception {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();

        if (disciplinas.isEmpty()) {
            throw new Exception("Data not found");
        }

        return disciplinas;
    }

    public List<Disciplina> saveDisciplinas(List<Disciplina> disciplinas) throws Exception {
        List<Disciplina> disciplinasSaved = new ArrayList<Disciplina>();

        for (Disciplina disciplina : disciplinas) {
            Optional<Professor> professor = professorService.findById(disciplina.getProfessor().getId());
            disciplina.setProfessor(professor.get());

            disciplinasSaved.add(
                    disciplinaRepository.save(disciplina));
        }
        return disciplinaRepository.saveAll(
                disciplinas);
    }
}
