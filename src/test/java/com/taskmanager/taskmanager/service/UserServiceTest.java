package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testRegisterUser() throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("John.Doe@example.com");
        user.setPassword("88888888");

        User saved = userService.registerUser(user);

        assertNotNull(saved.getId());
        assertEquals("John Doe", saved.getName());
        assertEquals("John.Doe@example.com", saved.getEmail());
    }
}
