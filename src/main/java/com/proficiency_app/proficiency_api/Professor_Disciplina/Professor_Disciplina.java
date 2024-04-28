package com.proficiency_app.proficiency_api.Professor_Disciplina;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Professor_Disciplina {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @ManyToMany
    @JoinColumn(name = "professor_id")
    private Professor professor_id;

    @ManyToMany
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina_id;
}
