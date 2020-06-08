package com.spring.springbootdemo.controller;


import com.spring.springbootdemo.model.User;
import com.spring.springbootdemo.model.api.ApiResponse;
import com.spring.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse findAll() {
        List<User> users = userService.findAll();
        if (users.size() > 0) {
            return new ApiResponse("200", "Data Retrieve Successfully.", users);
        }
        return new ApiResponse("404", "data not found!");
    }
}
