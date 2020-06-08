package com.spring.springbootdemo.services.Imp;

import com.spring.springbootdemo.model.User;
import com.spring.springbootdemo.repository.imp.UserRepositoryImp;
import com.spring.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepositoryImp userRepositoryImp;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateRole(User user) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepositoryImp.findAll();
    }
}
