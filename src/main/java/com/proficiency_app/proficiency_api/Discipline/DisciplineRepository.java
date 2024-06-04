package com.proficiency_app.proficiency_api.Discipline;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, String> {
    List<Discipline> findByCode(String code);

    List<Discipline> findByName(String name);

    Optional<Discipline> findById(String id);

}
