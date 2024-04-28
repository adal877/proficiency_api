package com.proficiency_app.proficiency_api.PalavraChave;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.proficiency_app.proficiency_api.Disciplina.Disciplina;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Questao.Questao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class PalavraChave {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    private String palavra;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

}
