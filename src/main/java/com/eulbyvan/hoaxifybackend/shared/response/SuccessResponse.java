package com.eulbyvan.hoaxifybackend.shared.response;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

public class SuccessResponse<T> extends GenericResponse{
    private List<T> data;

    public SuccessResponse(String code, String message, List<T> data) {
        super(code, "success", message);
        this.data = data;
    }
}
