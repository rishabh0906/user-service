package com.services.userService.interfaces;

import com.services.userService.models.User;
import com.services.userService.models.UserPayload;

public interface UserService {

    UserPayload createUser(UserPayload userPayload);

    User getUser(UserPayload userPayload);

    Iterable<User> getAllUsers();

    User updateUser(UserPayload userPayload);

    void deleteUser(UserPayload userPayload);

    void deleteAllUsers();

}
