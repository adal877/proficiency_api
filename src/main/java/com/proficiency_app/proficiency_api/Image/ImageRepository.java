package com.proficiency_app.proficiency_api.Image;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
   public List<Image> findAll();
   public Optional<Image> findById(String id);
}
