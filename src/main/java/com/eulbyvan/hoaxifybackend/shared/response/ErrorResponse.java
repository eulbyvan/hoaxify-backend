package com.eulbyvan.hoaxifybackend.shared.response;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

public class ErrorResponse extends GenericResponse{
    public ErrorResponse(String code, String message) {
        super(code, "error", message);
    }
}
