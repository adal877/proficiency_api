package com.proficiency_app.proficiency_api.Prova;

import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Resposta.Resposta;

import jakarta.persistence.Entity;
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
public class Opcao extends Data {
    @Lob
    private String texto;

    @ManyToOne
    @JoinColumn(name = "resposta_id")
    private Resposta resposta;
}
