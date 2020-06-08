package com.spring.springbootdemo.services;

import com.spring.springbootdemo.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean updateRole(User user);

    boolean deleteById(Long id);

    User findById(Long id);

    List<User> findAll();
}
