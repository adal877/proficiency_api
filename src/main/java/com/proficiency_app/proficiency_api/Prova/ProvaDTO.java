package com.proficiency_app.proficiency_api.Prova;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Questao.Questao;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProvaDTO {

    private String id;
    private String name;
    private Professor professor;
    private List<Questao> questoes;
}

