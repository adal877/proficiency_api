package com.proficiency_app.proficiency_api.Disciplina;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



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
    public ResponseEntity<?> getAllDisciplinas() {
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

}
