package com.services.userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.services.userService.Service.UserServiceImpl;
import com.services.userService.models.User;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String email
        , @RequestParam String password) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
      userServiceImpl.createUser(email, password);
      return "Saved";
    }
  
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return userServiceImpl.getAllUsers();
    }
    
}
