package com.eulbyvan.hoaxifybackend.shared.error.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 17/12/2022
 */

@Data
@NoArgsConstructor
public class ApiError {
    private long timestamp = new Date().getTime();
    private int status;
    private String message;
    private String url;
    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
