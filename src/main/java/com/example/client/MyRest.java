package com.example.client;

import com.example.server.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRest {

    @Autowired
    UserClient userService;

    @GetMapping("/get")
    public String getUser(){

      UserResponse userResponse = userService.sayUser(1);
        return userResponse.getUsername();
    }
}
