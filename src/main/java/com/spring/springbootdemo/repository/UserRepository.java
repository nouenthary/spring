package com.spring.springbootdemo.repository;

import com.spring.springbootdemo.model.User;

import java.util.List;

public interface UserRepository {

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteById(Long id);

    User findById(Long id);

    List<User> findAll();
}
