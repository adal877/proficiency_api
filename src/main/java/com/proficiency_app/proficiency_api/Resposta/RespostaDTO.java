package com.proficiency_app.proficiency_api.Resposta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RespostaDTO {

    private String id;
    private String texto;
    private Boolean correta;
    private TipoResposta tipoResposta;
}
