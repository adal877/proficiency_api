package com.proficiency_app.proficiency_api.Data;

import java.util.List;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class DataResponse {
    private String message;
    private int code;
    private List<Object> data;
}
