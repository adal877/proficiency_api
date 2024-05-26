package com.proficiency_app.proficiency_api.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proficiency_app.proficiency_api.Data.DataResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AnswerController {
    @Autowired
    AnswerService respostaService;

    public AnswerController(
            AnswerService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping("/answers")
    public ResponseEntity<?> getQuestoes() {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    respostaService.findAll());
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @GetMapping("/answers/{id}")
    public ResponseEntity<?> getResposta(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    Arrays.asList(
                            respostaService.findById(id)));
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/answer")
    public ResponseEntity<?> postResposta(@RequestBody @Valid Answer answer) {
        return postRespostas(new ArrayList<>(List.of(answer)));
    }

    @PostMapping("/answers")
    public ResponseEntity<?> postRespostas(@RequestBody @Valid List<Answer> answers) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                    respostaService.saveAll(answers));
        } catch (Exception ex) {
            response = DataResponse.postError(
                    ex.getMessage());
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }
}
