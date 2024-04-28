package com.proficiency_app.proficiency_api.Professor;

import com.proficiency_app.proficiency_api.Data.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "code")
    private String code;

    @Column(name = "password")
    private String password;
}
