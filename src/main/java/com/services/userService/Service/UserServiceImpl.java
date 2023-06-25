package com.services.userService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.userService.interfaces.UserService;
import com.services.userService.mapper.UserMapper;
import com.services.userService.models.User;
import com.services.userService.models.UserPayload;
import com.services.userService.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserPayload createUser(UserPayload userPayload) {
        User user = userMapper.toUser(userPayload);
        User savedUser = createUser(user);
        return userMapper.toPayload(savedUser);
    }

    private User createUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser!=null){
            throw new EntityExistsException("User Already Exists");
        }
        return userRepository.save(user);
    }

    public User getUserByEmailId(String email) {
        User existingUser = userRepository.findByEmail(email);
        if(existingUser==null){
            return null;
        }
        return existingUser;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    // To be implemented
    public User updateUser(UserPayload userPayload) {
        return null;
    }

    public void deleteUser(UserPayload userPayload) {
        User user = userMapper.toUser(userPayload);
        user = userRepository.findByEmail(user.getEmail());
        if(user==null){
            throw new EntityNotFoundException("User Not Found");
        }
        userRepository.delete(user);  
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
