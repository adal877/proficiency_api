package com.proficiency_app.proficiency_api.Professor_Disciplina;

import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.EmbeddedId;
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
public class Professor_Disciplina {
    @EmbeddedId
    private ProfessorDisciplinaId id;

    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", insertable = false, updatable = false)
    private Disciplina disciplina;
}
