package com.proficiency_app.proficiency_api.Disciplina;

import com.proficiency_app.proficiency_api.Data.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "code")
    private String code;
}
