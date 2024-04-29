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
        try {
            return ResponseEntity
                .ok()
                .body(
                    professorService.findAll()
                );
        } catch(Exception ex) {
            return ResponseEntity
                .badRequest()
                .body(
                    ex.getMessage()
                );
        }
    }

    @GetMapping("/professores/{id}")
    public ResponseEntity<?> getProfessor(@PathVariable String id) {
        DataResponse response = new DataResponse();
        try {
            response.setMessage("Found data");
            response.setCode(HttpStatus.FOUND.value());
            response.setData(
                Arrays.asList(
                    professorService.findById(id)
                )
            );

            return ResponseEntity
                .status(
                    HttpStatus.FOUND

                )
                .body(
                    response
                );
        } catch(Exception ex) {
            response.setMessage("Not found data");
            response.setCode(HttpStatus.NOT_FOUND.value());
            response.setData(
                Arrays.asList(
                    ex.getMessage()
                )
            );
            return ResponseEntity
                .status(
                    HttpStatus.NOT_FOUND
                )
                .body(
                    response
                );
        }
    }

    @PostMapping("/professores")
    public ResponseEntity<?> postProfessors(@RequestBody @Valid List<Professor> professors) {
        DataResponse response = new DataResponse();

        try {
            response.setMessage("Data created");
            response.setCode(HttpStatus.CREATED.value());
            response.setData(
                Arrays.asList(
                    professorService.saveAll(professors)
                )
            );
            return ResponseEntity
                .status(
                    HttpStatus.CREATED
                )
                .body(
                    response
                );
        } catch(Exception ex) {
            response.setMessage("Failed to create data");
            response.setCode(HttpStatus.FAILED_DEPENDENCY.value());
            response.setData(
                Arrays.asList(
                    ex.getMessage()
                )
            );

            return ResponseEntity
                .status(
                    HttpStatus.FAILED_DEPENDENCY
                )
                .body(
                    response
                );
        }
    }


}

