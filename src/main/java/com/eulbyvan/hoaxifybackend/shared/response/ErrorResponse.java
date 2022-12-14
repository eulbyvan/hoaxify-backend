package com.eulbyvan.hoaxifybackend.shared.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

@Data
public class ErrorResponse extends GenericResponse{
    public ErrorResponse(String code, String message) {
        super(code, "error", message);
    }
}