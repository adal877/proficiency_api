package com.proficiency_app.proficiency_api.Question;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Answer.Answer;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Exam.Exam;
import com.proficiency_app.proficiency_api.Image.Image;
import com.proficiency_app.proficiency_api.Professor.Professor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;
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
public class Question extends Data {
    @Lob
    private String content;

    @Column(name = "question_type")
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    @JoinTable(
        name = "question_image",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    @Size(max = 3, message = "Máximo de 3 Imagens por questão")
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Exam> exams = new ArrayList<>();

    @Override
    @PrePersist
    protected void prePersist() {
        super.prePersist();
        this.setRecordType(
            DataType.QUESTAO
        );
    }
}
