package com.eulbyvan.hoaxifybackend;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.repo.IUserRepo;
import com.eulbyvan.hoaxifybackend.shared.response.GenericResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 12/12/2022
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
    private static final String API_1_0_USERS = "/api/1.0/users";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    IUserRepo userRepo;

    @Before
    public void cleanup() {
        userRepo.deleteAll();
    }

    @Test
    public void postUser_whenUserIsValid_receiveHttpStatusCreated() {
        User user = createValidUser();
        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase() {
        User user = createValidUser();

        testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);

        assertThat(userRepo.count()).isEqualTo(1);
    }

    @Test
    public void postUser_whenUserIsValid_recieveSuccessMessage() {
        User user = createValidUser();
        ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);
        assertThat(response.getBody().getMessage()).isNotNull();
    }

    @Test
    public void postUser_whenUserIsValid_recieveCreated() {
        User user = createValidUser();
        ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postUser_whenUserIsValid_passwordIsHashedInDatabase() {
        User user = createValidUser();
        testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);

        List<User> users = userRepo.findAll();

        User userInDb = users.get(0);

        assertThat(userInDb.getPassword()).isNotEqualTo(user.getPassword());
    }

//    @Test
//    public void getUsers_receiveSuccessMessage() {
//        List<User> dummyUsers = new ArrayList<>();
//        dummyUsers.add(new User());
//
//        List<User> actualUsers = userRepo.findAll();
//
//        assertThat()
//    }

    private static User createValidUser() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setDisplayName("test-display");
        user.setPassword("P@ssw0rd");
        return user;
    }
}
