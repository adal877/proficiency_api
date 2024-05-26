package com.proficiency_app.proficiency_api.Discipline;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Professor.ProfessorService;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplinaRepository;
    @Autowired
    private ProfessorService professorService;

    public DisciplineService(
            DisciplineRepository disciplinaRepository,
            ProfessorService professorService) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorService = professorService;
    }

    public List<Discipline> findByCode(String code) {
        return disciplinaRepository.findByCode(code);
    }

    public List<Discipline> findByName(String name) {
        return disciplinaRepository.findByName(name);
    }

    public Optional<Discipline> findById(String id) throws Exception {
        Optional<Discipline> discipline = disciplinaRepository.findById(id);
        if (discipline.isEmpty()) {
            throw new Exception("Data not found");
        }

        return discipline;
    }

    public List<Discipline> findAll() throws Exception {
        List<Discipline> disciplines = disciplinaRepository.findAll();

        if (disciplines.isEmpty()) {
            throw new Exception("Data not found");
        }

        return disciplines;
    }

    public List<Discipline> saveDisciplinas(List<Discipline> disciplines) throws Exception {
        List<Discipline> disciplinasSaved = new ArrayList<Discipline>();

        for (Discipline discipline : disciplines) {
            Optional<Professor> professor = professorService.findById(discipline.getProfessor().getId());
            discipline.setProfessor(professor.get());
            discipline.setRecordType(DataType.DISCIPLINA);

            disciplinasSaved.add(
                    disciplinaRepository.save(discipline));
        }
        return disciplinaRepository.saveAll(
                disciplines);
    }
}
