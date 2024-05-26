package com.proficiency_app.proficiency_api.Professor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/professors")
    public ResponseEntity<?> getActiveOnlyProfessors(@RequestParam(name = "active", required = false, defaultValue = "true") Boolean active) {
        DataResponse<?> response = new DataResponse<>();

        try {
            if(!active) {
                response = DataResponse.getSuccess(
                        professorService.findAll());
            } else {
                response = DataResponse.getSuccess(
                    professorService.findByIsActive(active)
                );
            }
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @GetMapping("/professors/{id}")
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

    @PutMapping("/professor/{id}")
    public ResponseEntity<?> putProfessor(@PathVariable String Id, @RequestBody @Valid Professor professor) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response =
                DataResponse.postSuccess(
                    List.of(
                        professorService.save(
                            professor
                        )
                    )
                );
        } catch (Exception ex) {
            response = DataResponse.postError(
                    ex.getMessage());
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/professor")
    public ResponseEntity<?> postProfessor(@RequestBody @Valid Professor professor) {
        return postProfessors(new ArrayList<>(List.of(professor)));
    }

    @PostMapping("/professors")
    public ResponseEntity<?> postProfessors(@RequestBody @Valid List<Professor> professors) {
        logger.debug("Payload - professors: {}", professors);

        DataResponse<?> response = new DataResponse<>();

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

    @DeleteMapping("/professors/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            // professorService.deleteById(id);
            professorService.fakeDeleteById(id);
            response = DataResponse.deleteSuccess();
        } catch (Exception e) {
            response = DataResponse.deleteError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);

    }
}
