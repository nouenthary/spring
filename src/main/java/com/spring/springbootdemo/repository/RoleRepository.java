package com.spring.springbootdemo.repository;

import com.spring.springbootdemo.model.Role;

import java.util.List;

public interface RoleRepository {

    boolean addRole(Role role);

    boolean updateRole(Role role);

    boolean deleteById(Long id);

    Role findById(Long id);

    List<Role> findAll();

    List<Role> findRoleByUserId(Long id);

    Role findByRole(String role);
}
