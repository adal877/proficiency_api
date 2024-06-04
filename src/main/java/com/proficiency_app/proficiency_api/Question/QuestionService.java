package com.proficiency_app.proficiency_api.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proficiency_app.proficiency_api.Answer.Answer;
import com.proficiency_app.proficiency_api.Answer.AnswerDTO;
import com.proficiency_app.proficiency_api.Answer.AnswerService;
import com.proficiency_app.proficiency_api.Exam.Exam;
import com.proficiency_app.proficiency_api.Exam.ExamDTO;
import com.proficiency_app.proficiency_api.Exam.ExamRepository;
import com.proficiency_app.proficiency_api.Image.Image;
import com.proficiency_app.proficiency_api.Image.ImageService;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Professor.ProfessorService;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questaoRepository;

    @Autowired
    private AnswerService respostaService;

    @Autowired
    private ExamRepository provaRepository;

    @Autowired
    private ImageService ImageService;

    @Autowired
    private ProfessorService professorService;

    public QuestionService(
            QuestionRepository questaoRepository,
            AnswerService respostaService,
            ExamRepository provaRepository,
            ImageService ImageService,
            ProfessorService professorService) {
        this.questaoRepository = questaoRepository;
        this.respostaService   = respostaService;
        this.provaRepository   = provaRepository;
        this.ImageService     = ImageService;
        this.professorService  = professorService;
    }

    public Optional<Question> findById(String id) throws Exception {
        Optional<Question> question = questaoRepository.findById(id);

        if (question.isEmpty()) {
            throw new Exception("Data not found");
        }

        return question;
    }

    public List<Question> findAll() throws Exception {
        List<Question> questions = questaoRepository.findAll();

        if (questions.isEmpty()) {
            throw new Exception("Data not found");
        }

        return questions;
    }

    public List<Question> saveAll(List<Question> questions) throws Exception {
        for(Question question : questions) {
            question.setImages(
                ImageService.criarOuAtualizarImages(
                    question.getImages()
                )
            );
        }
        // return questaoRepository.saveAll(questions);
        return criarOuAtualizarQuestoes(questions);
    }

    public Question save(Question question) {
        return questaoRepository.save(question);
    }

    @Transactional
    public List<Question> criarOuAtualizarQuestoes(List<Question> questions) throws NotFoundException {
        List<Question> questoesSalvas = new ArrayList<>();

        for(Question question : questions) {
            Optional<Question> questaoExistente = questaoRepository.findById(question.getId());
            Question _question =
                questaoExistente.isPresent() ?
                    questaoExistente.get()
                    : new Question();
            _question.setContent(question.getContent());
            _question.setQuestionType(question.getQuestionType());
            _question.setProfessor(question.getProfessor());
            _question.setImages(question.getImages());
            _question.setAnswers(question.getAnswers());
            _question.setExams(question.getExams());
            questoesSalvas.add(
                questaoRepository.save(_question)
            );
        }

        return questoesSalvas;
    }

    /*
    public Questao questaoDtoTOEntity(QuestaoDTO questaoDTO) {
        Questao question = new Questao();
        question.setId(questaoDTO.getId());
        question.setTexto(questaoDTO.getTexto());
        question.setTipoQuestao(questaoDTO.getTipoQuestao());
        for (RespostaDTO respostaDto : questaoDTO.getRespostas()) {
            question.setResposta(
                    respostaService.respostaDtoToEntity(respostaDto));
        }
        return question;
    }
    */

    @Transactional()
    public List<Question> getAllQuestoes() {
        return questaoRepository.findAll();
        // return questions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /*
    private QuestaoDTO convertToDTO(Questao question) {
        QuestaoDTO questaodto = new QuestaoDTO();
        questaodto.setId(question.getId());
        questaodto.setTexto(question.getTexto());
        questaodto.setTipoQuestao(question.getTipoQuestao());
        questaodto.setProfessorId(question.getProfessor().getId());
        questaodto.setProfessorName(question.getProfessor().getName());
        questaodto.setRespostas(question.getRespostas().stream().map(this::convertToDTO).collect(Collectors.toList()));

        return questaodto;
    }
    */

    private AnswerDTO convertToDTO(Answer answer) {
        AnswerDTO dto = new AnswerDTO();
        dto.setId(answer.getId());
        dto.setTexto(answer.getContent());
        dto.setCorreta(answer.isCorrect());
        dto.setQuestaoId(answer.getQuestion().getId());
        dto.setTipoResposta(answer.getAnswerType());
        return dto;
    }

    private ExamDTO convertToDTO(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getTitle());
        dto.setProfessorId(exam.getProfessor().getId());
        return dto;
    }

    public Question createQuestion(String content, QuestionType questionType, String professorId, List<MultipartFile> images) throws Exception {
        Question question = new Question();
        question.setContent(content);
        question.setQuestionType(questionType);

        Optional<Professor> professor = professorService.findById(professorId);
        if (professor.isPresent()) {
            question.setProfessor(professor.get());
        } else {
            throw new RuntimeException("Professor not found");
        }

        List<Image> imageEntities = new ArrayList<>();
        for (MultipartFile image : images) {
            if (image != null && !image.isEmpty()) {
                Image imageEntity = new Image();
                imageEntity.setRaw_data(image.getBytes());
                imageEntity.setDescription(image.getOriginalFilename());
                imageEntities.add(ImageService.save(imageEntity));
            }
        }

        question.setImages(imageEntities);
        return questaoRepository.save(question);
    }

    public Question updateQuestion(String id, String content, QuestionType questionType, String professorId, List<MultipartFile> images) throws Exception {
        Optional<Question> existingQuestion = questaoRepository.findById(id);
        if (existingQuestion.isPresent()) {
            Question question = existingQuestion.get();
            question.setContent(content);
            question.setQuestionType(questionType);

            Optional<Professor> professor = professorService.findById(professorId);
            if (professor.isPresent()) {
                question.setProfessor(professor.get());
            } else {
                throw new RuntimeException("Professor not found");
            }

            // Clear existing images
            question.getImages().clear();

            List<Image> imageEntities = new ArrayList<>();
            for (MultipartFile image : images) {
                if (image != null && !image.isEmpty()) {
                    Image imageEntity = new Image();
                    imageEntity.setRaw_data(image.getBytes());
                    imageEntity.setDescription(image.getOriginalFilename());
                    imageEntities.add(ImageService.save(imageEntity));
                }
            }

            question.setImages(imageEntities);
            return questaoRepository.save(question);
        } else {
            throw new RuntimeException("Question not found");
        }
    }

    /*
     * public Optional<Questao> findByType(String tipoQuestao) {
     * return questaoRepository.findByTipoQuestao(tipoQuestao);
     * }
     */
}
