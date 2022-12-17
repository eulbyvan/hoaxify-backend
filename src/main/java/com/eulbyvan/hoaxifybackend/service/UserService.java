package com.eulbyvan.hoaxifybackend.service;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.repo.IUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

@Service
public class UserService implements IUserService{
    private IUserRepo userRepo;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepo userRepo) {
        super();
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Long count() {
        return userRepo.count();
    }
}
