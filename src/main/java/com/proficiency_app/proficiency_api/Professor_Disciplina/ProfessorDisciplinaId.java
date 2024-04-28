package com.proficiency_app.proficiency_api.Professor_Disciplina;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessorDisciplinaId implements Serializable {
    private String professor_id;
    private String disciplina_id;

    // Implemente equals() e hashCode() (necessários para JPA)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ProfessorDisciplinaId that = (ProfessorDisciplinaId) obj;

        if (!professor_id.equals(that.professor_id)) return false;
        return disciplina_id.equals(that.disciplina_id);
    }

    @Override
    public int hashCode() {
        int result = professor_id.hashCode();
        result = 31 * result + disciplina_id.hashCode();
        return result;
    }
}
