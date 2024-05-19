package com.proficiency_app.proficiency_api.Data;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class Data {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "recordType", nullable = false)
    private DataType recordType;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
        isActive  = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @PreDestroy
    protected void onDestroy() {
        isActive = false;
    }
}
