package com.proficiency_app.proficiency_api.Disciplina;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Professor.Professor;

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
public class Disciplina extends Data {
    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    private Professor professor;
}
