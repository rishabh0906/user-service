package com.services.userService.interfaces;

import com.services.userService.models.User;

public interface UserService {

    User createUser(String email, String password);

    User getUser(String email);

    Iterable<User> getAllUsers();

    User updateUser(String email);

    void deleteUser(String email);

    void deleteAllUsers();

}
