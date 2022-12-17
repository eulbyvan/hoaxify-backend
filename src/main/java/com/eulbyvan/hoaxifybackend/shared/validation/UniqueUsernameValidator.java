package com.eulbyvan.hoaxifybackend.shared.validation;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.repo.IUserRepo;
import com.eulbyvan.hoaxifybackend.shared.annotation.UniqueUsername;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 18/12/2022
 */

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    IUserRepo userRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDB = userRepo.findByUsername(value);
        return inDB == null;
    }
}
