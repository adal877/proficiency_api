package com.proficiency_app.proficiency_api.Exam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamDTO {

    private String id;
    private String name;
    private String professorId;
}
