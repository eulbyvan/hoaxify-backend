package com.eulbyvan.hoaxifybackend.repo;

import com.eulbyvan.hoaxifybackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
