package com.eulbyvan.hoaxifybackend.service;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.repo.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

@Service
public class UserService implements IUserService{
    private IUserRepo userRepo;

    public UserService(IUserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public Long count() {
        return userRepo.count();
    }
}
