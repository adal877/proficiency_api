package com.proficiency_app.proficiency_api.Exam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Professor.ProfessorService;
import com.proficiency_app.proficiency_api.Question.QuestionService;

import jakarta.transaction.Transactional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository provaRepository;

    @Autowired
    private QuestionService questaoService;

    @Autowired
    private ProfessorService professorService;

    public ExamService(
            ExamRepository provaRepository,
            QuestionService questaoService,
            ProfessorService professorService) {
        this.provaRepository  = provaRepository;
        this.questaoService   = questaoService;
        this.professorService = professorService;
    }

    public Optional<Exam> findById(String id) throws Exception {
        Optional<Exam> exam = provaRepository.findById(id);

        if (exam.isEmpty()) {
            throw new Exception("Data not found");
        }

        return exam;
    }

    public List<Exam> findAll() throws Exception {
        List<Exam> exams = provaRepository.findAll();

        if (exams.isEmpty()) {
            throw new Exception("Data not found");
        }

        return exams;
    }

    public List<Exam> findByProfessorId(String professor_id) {
        return provaRepository.findByProfessorId(professor_id);
    }

    public List<Exam> saveAll(List<Exam> exams) throws Exception {
        for(Exam exam : exams) {
            Optional<Professor> professor = professorService.findById(
                exam.getProfessor().getId()
            );

            exam.setProfessor(professor.get());
            exam.setRecordType(DataType.QUESTAO);
        }
        return provaRepository.saveAll(exams);
    }

    public Exam save(Exam exam) {
        return provaRepository.save(exam);
    }

    @Transactional
    public Exam criarOuAtualizarProva(ExamDTO provaRequestDto) throws Exception {
                Exam exam = new Exam();
        if (provaRequestDto.getId() != null) {
            exam = provaRepository.findById(provaRequestDto.getId())
                    .orElseThrow(() -> new NotFoundException());
        }

        exam.setTitle(provaRequestDto.getName());
        exam.setProfessor(
            professorService.findById(
                provaRequestDto.getProfessorId()
            ).get()
        );

        return provaRepository.save(exam);
    }

    @Transactional
    public boolean deletarProva(String id) {
        Exam exam = provaRepository.findById(id).orElse(null);
        if (exam != null) {
            provaRepository.delete(exam);
            return true;
        }
        return false;
    }
}
