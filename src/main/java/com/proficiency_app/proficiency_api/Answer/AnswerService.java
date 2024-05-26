package com.proficiency_app.proficiency_api.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Question.Question;

import jakarta.transaction.Transactional;

@Service
public class AnswerService {
    @Autowired
    private final AnswerRepository respostaRepository;

    public AnswerService(
        AnswerRepository respostaRepository
    ) {
        this.respostaRepository = respostaRepository;
    }

    public Optional<Answer> findById(String id) throws Exception {
        Optional<Answer> answer = respostaRepository.findById(id);

        if(answer.isEmpty()) {
            throw new Exception("Data not found");
        }

        return answer;
    }

    public List<Answer> findAll() throws Exception {
        List<Answer> answers = respostaRepository.findAll();

        if(answers.isEmpty()) {
            throw new Exception("Data not found");
        }

        return answers;
    }

    public List<Answer> saveAll(List<Answer> answers) {
        return respostaRepository.saveAll(answers);
    }

    public Answer save(Answer answer) {
        return respostaRepository.save(answer);
    }

    @Transactional
    public List<Answer> criarOuAtualizarRespostas(AnswerDTO respostaDto, Question question) {
        return criarOuAtualizarRespostas(new ArrayList<>(List.of(respostaDto)), question);
    }

    @Transactional
    public List<Answer> criarOuAtualizarRespostas(List<AnswerDTO> respostasDto, Question question) {
        List<Answer> answers = new ArrayList<>();

        for (AnswerDTO respostaDto : respostasDto) {
            Answer answer;
            if (respostaDto.getId() != null) {
                answer = respostaRepository.findById(respostaDto.getId()).orElse(new Answer());
            } else {
                answer = new Answer();
            }

            answer.setContent(respostaDto.getTexto());
            answer.setQuestion(question);

            answers.add(respostaRepository.save(answer));
        }

        return answers;
    }

    public Answer respostaDtoToEntity(AnswerDTO respostaDTO) {
        Answer answer = new Answer();

        answer.setId(answer.getId());
        answer.setContent(respostaDTO.getTexto());
        answer.setCorrect(respostaDTO.getCorreta());
        answer.setAnswerType(respostaDTO.getTipoResposta());

        return answer;
    }
}
