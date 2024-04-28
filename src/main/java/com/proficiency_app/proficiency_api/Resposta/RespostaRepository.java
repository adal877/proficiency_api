package com.proficiency_app.proficiency_api.Resposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, String> {
    Optional<Resposta> findById(String id);
    List<Resposta> findAll();
}
