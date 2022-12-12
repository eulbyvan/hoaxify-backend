package com.eulbyvan.hoaxifybackend.controller;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 13/12/2022
 */

@RestController
@RequestMapping("/api/1.0/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User req) {
        User res = userService.add(req);

        return ResponseEntity.ok().body(res);
    }
}
