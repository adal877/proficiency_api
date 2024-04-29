package com.proficiency_app.proficiency_api.Data;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false)
    private DataType record_type;

    @Column(name = "is_active", nullable = false)
    private Boolean is_active;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
        updated_at = new Date();
        is_active  = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }

    @PreDestroy
    protected void onDestroy() {
        is_active = false;
    }
}
