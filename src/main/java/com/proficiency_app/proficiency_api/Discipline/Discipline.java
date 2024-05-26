package com.proficiency_app.proficiency_api.Discipline;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Discipline extends Data {
    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "professor_email")
    private String professor_email;

    @Override
    @PrePersist
    protected void prePersist() {
        super.prePersist();
        this.professor_email = this.professor.getEmail();
        this.setRecordType(
            DataType.DISCIPLINA
        );
    }
}