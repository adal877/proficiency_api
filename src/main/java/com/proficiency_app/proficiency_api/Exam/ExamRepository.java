package com.proficiency_app.proficiency_api.Exam;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
    Optional<Exam> findById(String id);

    List<Exam> findAll();

    @Query("SELECT e FROM Exam e WHERE e.professor.id = :professor_id")
    List<Exam> findByProfessorId(@Param("professor_id") String professor_id);
}
