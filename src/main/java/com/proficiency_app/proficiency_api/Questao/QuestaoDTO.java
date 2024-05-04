package com.proficiency_app.proficiency_api.Questao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.proficiency_app.proficiency_api.Resposta.RespostaDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestaoDTO {

    private String id;
    private String texto;
    private TipoQuestao tipoQuestao;
    private List<RespostaDTO> respostas;
}
