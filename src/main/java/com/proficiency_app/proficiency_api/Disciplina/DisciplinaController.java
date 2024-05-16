package com.proficiency_app.proficiency_api.Disciplina;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
public class DisciplinaController {
    @Autowired
    DisciplinaService disciplinaService;

    public DisciplinaController(
            DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/disciplinas")
    public ResponseEntity<?> getDisciplinas() {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                    disciplinaService.findAll());
        } catch (Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<?> getDisciplina(@PathVariable String id) throws Exception {
        DataResponse<?> response = new DataResponse<>();
        Optional<Disciplina> disciplina = disciplinaService.findById(id);

        try {
            response = DataResponse.getError();
        } catch (Exception ex) {
            response = DataResponse.getSuccess(
                    Arrays.asList(
                            disciplina));
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/disciplinas")
    public ResponseEntity<?> postDisciplinas(@RequestBody @Valid List<Disciplina> disciplinas) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                    disciplinaService.saveDisciplinas(disciplinas));
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
