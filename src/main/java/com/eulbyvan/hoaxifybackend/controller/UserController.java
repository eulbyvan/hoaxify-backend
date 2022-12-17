package com.eulbyvan.hoaxifybackend.controller;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.service.IUserService;
import com.eulbyvan.hoaxifybackend.shared.response.GenericResponse;
import com.eulbyvan.hoaxifybackend.shared.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<GenericResponse> addUser(@Valid @RequestBody User req) {
        User user = userService.add(req);
        SuccessResponse<User> res = new SuccessResponse<User>("01", "created", List.of(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
