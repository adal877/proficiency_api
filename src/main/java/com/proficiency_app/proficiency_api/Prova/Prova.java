package com.proficiency_app.proficiency_api.Prova;

import java.util.List;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Questao.Questao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
public class Prova extends Data {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(
        mappedBy = "prova",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Questao> questao;
}
