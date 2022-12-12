package com.eulbyvan.hoaxifybackend.service;

import com.eulbyvan.hoaxifybackend.model.User;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

public interface IUserService {
    User add(User user);

    Long count();
}
