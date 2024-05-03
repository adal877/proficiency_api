package com.proficiency_app.proficiency_api.Professor;

import org.springframework.web.bind.annotation.RestController;

import com.proficiency_app.proficiency_api.Data.DataResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    public ProfessorController(
        ProfessorService professorService
    ) {
        this.professorService = professorService;
    }

    @GetMapping("/professores")
    public ResponseEntity<?> getProfessors() {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                professorService.findAll()
            );
        } catch(Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
            .ok()
            .body(
                response
            );
    }

    @GetMapping("/professores/{id}")
    public ResponseEntity<?> getProfessor(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                Arrays.asList(
                    professorService.findById(id)
                )
            );
        } catch(Exception ex) {
            response = DataResponse.getError();
        }

        return ResponseEntity
            .ok()
            .body(
                response
            );
    }

    @PostMapping("/professores")
    public ResponseEntity<?> postProfessors(@RequestBody @Valid List<Professor> professors) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                professorService.saveAll(professors)
            );
        } catch(Exception ex) {
            response = DataResponse.postError(
                ex.getMessage()
            );
        }

        return ResponseEntity
            .ok()
            .body(
                response
            );
    }
}

