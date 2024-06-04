package com.proficiency_app.proficiency_api.Image;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proficiency_app.proficiency_api.Data.Data;
import com.proficiency_app.proficiency_api.Data.DataType;
import com.proficiency_app.proficiency_api.Question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
public class Image extends Data {
    @Lob
    @Column(name = "raw_data", nullable = false)
    private byte[] raw_data;

    @Column(name = "data_size")
    @Size(max = 2 * 1024 * 1024, message = "Tamanho máximo da Image: 2MB")
    private long size;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "images")
    private List<Question> questions;

    @Override
    @PrePersist
    @PreUpdate
    protected void prePersist() {
        super.prePersist();
        this.size = this.raw_data.length;
        this.setRecordType(
            DataType.Image
        );
    }
}
