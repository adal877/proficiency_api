package com.proficiency_app.proficiency_api.Questao;

import java.util.List;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Prova.Prova;
import com.proficiency_app.proficiency_api.Resposta.Resposta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Questao extends Data {
    @Lob
    private String texto;

    @Column(name = "tipo_questao")
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipoQuestao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;

}
