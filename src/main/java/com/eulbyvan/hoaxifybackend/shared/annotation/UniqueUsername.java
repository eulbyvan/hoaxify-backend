package com.eulbyvan.hoaxifybackend.shared.annotation;

import com.eulbyvan.hoaxifybackend.shared.validation.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 18/12/2022
 */

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "{hoaxify.constraints.username.UniqueUsername.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
