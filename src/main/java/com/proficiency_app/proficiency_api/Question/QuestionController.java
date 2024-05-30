package com.proficiency_app.proficiency_api.Question;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proficiency_app.proficiency_api.Data.DataResponse;
import com.proficiency_app.proficiency_api.Image.ImageService;

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


    @PostMapping
    public ResponseEntity<Question> createQuestion(
            @RequestParam("content") String content,
            @RequestParam("questionType") QuestionType questionType,
            @RequestParam("professorId") Long professorId,
            @RequestParam("image0") MultipartFile image0,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("image2") MultipartFile image2,
            @RequestParam("image3") MultipartFile image3) {
        List<MultipartFile> images = List.of(image0, image1, image2, image3);
        Question question = questoeservice.createQuestion(content, questionType, professorId, images);
        return ResponseEntity.ok(question);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long id,
            @RequestParam("content") String content,
            @RequestParam("questionType") QuestionType questionType,
            @RequestParam("professorId") Long professorId,
            @RequestParam("image0") MultipartFile image0,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("image2") MultipartFile image2,
            @RequestParam("image3") MultipartFile image3) {
        List<MultipartFile> images = List.of(image0, image1, image2, image3);
        Question question = questoeservice.updateQuestion(id, content, questionType, professorId, images);
        return ResponseEntity.ok(question);
    }

    /*
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
    */

}
