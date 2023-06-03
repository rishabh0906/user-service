package com.services.userService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.userService.interfaces.UserService;
import com.services.userService.models.User;
import com.services.userService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String email) {
        return null;
    }

    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
