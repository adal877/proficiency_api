package com.proficiency_app.proficiency_api.Questao;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
public class Questao {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Lob
    private String texto;

    @Enumerated(EnumType.STRING)
    private TipoQuestao tipoQuestao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
