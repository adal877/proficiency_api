package com.proficiency_app.proficiency_api.Prova;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proficiency_app.proficiency_api.Professor.Professor;


@Repository
public interface ProvaRepository extends JpaRepository<Prova, String> {
    Optional<Prova> findById(String id);
    List<Prova> findAll();
    @Query("SELECT p FROM Prova p WHERE professor.id = :professor_id")
    List<Prova> findByProfessorId(String professor_id);
}
