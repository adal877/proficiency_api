package com.proficiency_app.proficiency_api.Prova;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Questao.Questao;

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
public class ProvaQuestao extends Data {
    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
}
