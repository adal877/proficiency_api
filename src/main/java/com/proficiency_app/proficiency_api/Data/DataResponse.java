package com.proficiency_app.proficiency_api.Data;

import java.util.List;

import org.springframework.http.HttpStatus;

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
public class DataResponse<T> {
    private String message;
    private int code;
    private List<T> data;

    public static <T> DataResponse<T> success(String message, List<T> data) {
        return new DataResponse<>(message, HttpStatus.OK.value(), data);
    }

    public static <T> DataResponse<T> getSuccess(List<T> data) {
        return new DataResponse<>(
            "Found data",
            HttpStatus.FOUND.value(),
            data
        );
    }

    public static <T> DataResponse<T> postSuccess(List<T> data) {
        return new DataResponse<>(
            "Data created",
            HttpStatus.CREATED.value(),
            data
        );
    }

    public static <T> DataResponse<T> deleteSuccess() {
        return new DataResponse<>(
            "Data deleted",
            HttpStatus.ACCEPTED.value(),
            null
        );
    }

    public static <T> DataResponse<T> deleteError() {
        return new DataResponse<>(
            "Failed to delete data",
            HttpStatus.EXPECTATION_FAILED.value(),
            null
        );
    }

    public static <T> DataResponse<T> error(String message, HttpStatus status) {
        return new DataResponse<>(message, status.value(), null);
    }

    public static <T> DataResponse<T> getError() {
        return new DataResponse<>(
            "Data not found",
            HttpStatus.NOT_FOUND.value(),
            null
        );
    }

    public static <T> DataResponse<T> postError() {
        return new DataResponse<>(
            "Unable to create data",
            HttpStatus.EXPECTATION_FAILED.value(),
            null
        );
    }

    public static <T> DataResponse<T> postError(String message, List<T> data) {
        return new DataResponse<>(
            message,
            HttpStatus.EXPECTATION_FAILED.value(),
            data
        );
    }

    public static <T> DataResponse<T> postError(String message) {
        return new DataResponse<>(
            message,
            HttpStatus.EXPECTATION_FAILED.value(),
            null
        );
    }
}
