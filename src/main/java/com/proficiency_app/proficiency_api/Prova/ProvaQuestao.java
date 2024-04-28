package com.proficiency_app.proficiency_api.Prova;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

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
public class ProvaQuestao {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
}
