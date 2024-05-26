package com.proficiency_app.proficiency_api.Professor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Answer.Answer;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Discipline.Discipline;
import com.proficiency_app.proficiency_api.Exam.Exam;
import com.proficiency_app.proficiency_api.Question.Question;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
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
public class Professor extends Data {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "professor")
    private List<Discipline> disciplines;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Exam> exams;

    @Override
    @PrePersist
    protected void prePersist() {
        super.prePersist();
        if(this.code.isEmpty()) {
            this.code = String.format(
                "%s",
                email
            );
        }
        this.name = String.format(
            "%s %s",
            this.firstName,
            this.lastName
        );
        this.setRecordType(
            DataType.PROFESSOR
        );
    }
}
