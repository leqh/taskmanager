package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws Exception {
        // Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("Email already registered");
        }
        // TODO: Hash password later
        return userRepository.save(user);
    }
}
