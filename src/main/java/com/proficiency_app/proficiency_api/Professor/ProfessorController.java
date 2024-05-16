package com.proficiency_app.proficiency_api.Professor;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProfessorController {
    final Logger logger = LoggerFactory.getLogger(ProfessorController.class);
    @Autowired
    ProfessorService professorService;

    public ProfessorController(
            ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/professores")
    public ResponseEntity<?> getProfessors() {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    professorService.findAll());
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @GetMapping("/professores/{id}")
    public ResponseEntity<?> getProfessor(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    Arrays.asList(
                            professorService.findById(id)));
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/professores")
    public ResponseEntity<?> postProfessors(@RequestBody @Valid List<Professor> professors) {
        DataResponse<?> response = new DataResponse<>();

        logger.info("Payload - professores: {}", professors.toString());

        try {
            response = DataResponse.postSuccess(
                    professorService.saveAll(professors));
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
