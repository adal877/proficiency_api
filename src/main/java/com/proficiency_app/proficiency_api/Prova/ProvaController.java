package com.proficiency_app.proficiency_api.Prova;

import org.springframework.web.bind.annotation.RestController;

import com.proficiency_app.proficiency_api.Data.DataResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
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
public class ProvaController {
    @Autowired
    ProvaService provaService;

    public ProvaController(
        ProvaService provaService
    ) {
        this.provaService = provaService;
    }

    @GetMapping("/provas")
    public ResponseEntity<?> getProvas() {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                provaService.findAll()
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

    @GetMapping("/provas/{id}")
    public ResponseEntity<?> getProva(@PathVariable String id) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.getSuccess(
                Arrays.asList(
                    provaService.findById(id)
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

    @PostMapping("/provas")
    public ResponseEntity<?> postProvas(@RequestBody @Valid List<Prova> provas) {
        DataResponse<?> response = new DataResponse<>();

        try {
            response = DataResponse.postSuccess(
                provaService.saveAll(provas)
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
