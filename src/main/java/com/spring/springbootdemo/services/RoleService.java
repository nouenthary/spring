package com.spring.springbootdemo.services;

import com.spring.springbootdemo.model.Role;

import java.util.List;

public interface RoleService {

    boolean addRole(Role role);

    boolean updateRole(Role role);

    boolean deleteById(Long id);

    Role findById(Long id);

    List<Role> findAll();

    Role getByRole(String role);
}
