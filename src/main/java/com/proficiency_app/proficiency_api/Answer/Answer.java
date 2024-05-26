package com.proficiency_app.proficiency_api.Answer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Professor.Professor;
import com.proficiency_app.proficiency_api.Question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Answer extends Data {
    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Enumerated(EnumType.STRING)
    private AnswerType answerType;

    @Override
    @PrePersist
    protected void prePersist() {
        super.prePersist();
        this.setRecordType(
            DataType.RESPOSTA
        );
    }
}
