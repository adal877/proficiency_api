package com.proficiency_app.proficiency_api.Disciplina;

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
public class DisciplinaController {
    @Autowired
    DisciplinaService disciplinaService;

    public DisciplinaController(
        DisciplinaService disciplinaService
    ) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/disciplinas")
    public ResponseEntity<?> getDisciplinas() {
        try {
            return ResponseEntity
                .ok()
                .body(
                    disciplinaService.findAll()
                );
        } catch(Exception ex) {
            return ResponseEntity
                .badRequest()
                .body(
                    ex.getMessage()
                );
        }
    }

    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<?> getDisciplina(@PathVariable String id) {
        DataResponse response = new DataResponse();
        try {
            response.setMessage("Found data");
            response.setCode(HttpStatus.FOUND.value());
            response.setData(
                Arrays.asList(
                    disciplinaService.findById(id)
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

    @PostMapping("/disciplinas")
    public ResponseEntity<?> postDisciplinas(@RequestBody @Valid List<Disciplina> disciplinas) {
        DataResponse response = new DataResponse();

        try {
            response.setMessage("Data created");
            response.setCode(HttpStatus.CREATED.value());
            response.setData(
                Arrays.asList(
                    disciplinaService.saveDisciplinas(disciplinas)
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
