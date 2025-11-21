package com.usedcars.user.service;

import com.usedcars.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    String login(String email, String password);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    void deleteUser(Long id);
    boolean emailExists(String email);
}