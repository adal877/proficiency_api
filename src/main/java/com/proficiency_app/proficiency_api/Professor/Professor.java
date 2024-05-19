package com.proficiency_app.proficiency_api.Professor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Disciplina.Disciplina;

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
public class Professor extends Data {
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

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
    @JsonManagedReference
    private List<Disciplina> disciplinas;

    @PrePersist
    protected void prePersist() {
        this.name = String.format(
            "%s %s",
            this.first_name,
            this.last_name
        );
    }
}
