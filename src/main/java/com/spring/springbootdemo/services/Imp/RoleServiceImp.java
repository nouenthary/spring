package com.spring.springbootdemo.services.Imp;

import com.spring.springbootdemo.model.Role;
import com.spring.springbootdemo.repository.RoleRepository;
import com.spring.springbootdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public boolean addRole(Role role) {
        return repository.addRole(role);
    }

    @Override
    public boolean updateRole(Role role) {
        Role roleFind = repository.findById(role.getId());
        if (roleFind != null) {
            roleFind.setRole_name(role.getRole_name());
        }
        return repository.updateRole(role);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role getByRole(String role) {
        return repository.findByRole(role);
    }
}
