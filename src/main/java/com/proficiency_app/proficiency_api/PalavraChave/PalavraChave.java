package com.proficiency_app.proficiency_api.PalavraChave;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Questao.Questao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PalavraChave extends Data {
    @Column(name = "palavra")
    private String palavra;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

}
