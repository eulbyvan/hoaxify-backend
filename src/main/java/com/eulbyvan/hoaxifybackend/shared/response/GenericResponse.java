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
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
    private String code;
    private String status;
    private String message;
}
