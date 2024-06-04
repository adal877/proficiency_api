package com.proficiency_app.proficiency_api.Question;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionDTO {
    private String id;
    private String texto;
    private QuestionType tipoQuestao;
    private String professorId;
    private String professorName;
    private List<String> answers;
    private String exam;
}
