package com.proficiency_app.proficiency_api.ExamsGenerations;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Exam.Exam;

import jakarta.persistence.Entity;
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
public class ExamsGenerations extends Data {
    private int amountOfExams = 0;
    private ArrayList<Exam> exams = new ArrayList<Exam>();
}
