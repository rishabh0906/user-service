package com.services.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.services.userService.Service.UserServiceImpl;
import com.services.userService.models.User;
import com.services.userService.models.UserPayload;

@RestController
@RequestMapping(path="/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody UserPayload addNewUser (@RequestBody UserPayload userPayload) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
      return userServiceImpl.createUser(userPayload);
    }
    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return userServiceImpl.getAllUsers();
    }

    @DeleteMapping
    public @ResponseBody void deleteUser(@RequestParam UserPayload userPayload) {
       userServiceImpl.deleteUser(userPayload);

    }

    @DeleteMapping(path="/deleteAll")
    public @ResponseBody String deleteAllUsers() {
       userServiceImpl.deleteAllUsers();

      return "All Users Deleted";
    }
    
}
