package com.proficiency_app.proficiency_api.Answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnswerDTO {

    private String id;
    private String texto;
    private Boolean correta;
    private AnswerType tipoResposta;
    private String questaoId;
}
