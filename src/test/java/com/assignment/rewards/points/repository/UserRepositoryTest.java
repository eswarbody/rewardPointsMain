package com.assignment.rewards.points.repository;


import com.assignment.rewards.points.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
@DataJpaTest
@TestPropertySource(properties = "spring.config.location=classpath:/application-test.properties")

public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    private static LocalDate the_date = LocalDate.of(1999,10,10);


    @Autowired
    private UserRepository repository;


    @BeforeEach
    public void setUp(){



    }


    @Test
    public void should_find_after_save() {
        User user = new User();
        Assertions.assertNull(user.getUserID());
        entityManager.persist(user);
        entityManager.persist(user);
        Iterable result = repository.findAll();
        Assertions.assertNotNull(user.getUserID());

        assertThat(result).hasSize(1).contains(user);
    }
}
