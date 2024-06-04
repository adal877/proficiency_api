package com.proficiency_app.proficiency_api.Discipline;

import java.util.ArrayList;
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
public class DisciplineController {
    @Autowired
    DisciplineService disciplinaService;

    public DisciplineController(
            DisciplineService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/disciplines")
    public ResponseEntity<?> getDisciplinas() {
        DataResponse<Discipline> response = new DataResponse<>();

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

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<?> getDisciplina(@PathVariable String id) throws Exception {
        DataResponse<Optional<Discipline>> response = new DataResponse<>();
        Optional<Discipline> discipline = disciplinaService.findById(id);

        try {
            response = DataResponse.getError();
        } catch (Exception ex) {
            response = DataResponse.getSuccess(
                    Arrays.asList(
                            discipline));
        }

        return ResponseEntity
                .ok()
                .body(
                        response);
    }

    @PostMapping("/discipline")
    public ResponseEntity<?> postDisciplina(@RequestBody @Valid Discipline discipline) {
        return postDisciplinas(new ArrayList<>(List.of(discipline)));
    }

    @PostMapping("/disciplines")
    public ResponseEntity<?> postDisciplinas(@RequestBody @Valid List<Discipline> disciplines) {
        DataResponse<Discipline> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                    disciplinaService.saveDisciplinas(disciplines));
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
