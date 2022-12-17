package com.eulbyvan.hoaxifybackend;

import com.eulbyvan.hoaxifybackend.model.User;
import com.eulbyvan.hoaxifybackend.repo.IUserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 18/12/2022
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    IUserRepo userRepo;

    @Test
    public void findByUsername_whenUserExists_returnsUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setPassword("P@ssw0rd");
        user.setDisplayName("test-display");

        testEntityManager.persist(user);
        User userInDb = userRepo.findByUsername("test-user");

        assertThat(userInDb).isNotNull();
    }

    @Test
    public void findByUsername_whenUserDoesNotExist_returnsNull() {
        User userInDb = userRepo.findByUsername("nonexistinguser");
        assertThat(userInDb).isNull();
    }

}
