package com.proficiency_app.proficiency_api.Professor_Disciplina;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor_Disciplina extends Data {
    @ManyToMany
    @JoinColumn(name = "professor_id")
    private Professor professor_id;

    @ManyToMany
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina_id;
}
