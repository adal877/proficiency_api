package com.proficiency_app.proficiency_api.Prova;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.proficiency_app.proficiency_api.Resposta.Resposta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Opcao {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Lob
    private String texto;

    @ManyToOne
    @JoinColumn(name = "resposta_id")
    private Resposta resposta;
}
