package com.proficiency_app.proficiency_api.Question;

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
import com.proficiency_app.proficiency_api.Image.ImageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
    @Autowired
    QuestionService questoeservice;

    @Autowired
    ImageService ImageService;

    public QuestionController(
            QuestionService questoeservice,
            ImageService ImageService) {
        this.questoeservice = questoeservice;
        this.ImageService  = ImageService;
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getQuestoes() {
        DataResponse<?> response = new DataResponse<>();

        try {
            /*
            response = DataResponse.getSuccess(
                    questoeservice.findAll());
                    */
            response = DataResponse.getSuccess(
                questoeservice.getAllQuestoes()
            );
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<?> getQuestao(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    Arrays.asList(
                            questoeservice.findById(id)));
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/question")
    public ResponseEntity<?> postquestoe(@RequestBody @Valid Question question) {
        return postquestoes(new ArrayList<>(List.of(question)));
    }

    @PostMapping("/questions")
    public ResponseEntity<?> postquestoes(@RequestBody @Valid List<Question> questions) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                    questoeservice.saveAll(questions));
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
