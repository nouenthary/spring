package com.spring.springbootdemo.controller;

import com.spring.springbootdemo.model.Role;
import com.spring.springbootdemo.model.api.ApiResponse;
import com.spring.springbootdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ApiResponse findAll() {
        List<Role> roles = roleService.findAll();
        if (roles.size() > 0) {
            return new ApiResponse("200", "Record retrieve Successfully", roleService.findAll());
        } else {
            return new ApiResponse("404", "not found!");
        }
    }

    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable("id") Long id) {
        Role role = roleService.findById(id);
        if (role != null) {
            return new ApiResponse("200", "Record retrieve Successfully", role);
        }
        return new ApiResponse("404", "Id " + id + " not found!");
    }

    @PostMapping
    public ApiResponse addRole(@RequestBody Role role) {
        if (roleService.addRole(role)) {
            return new ApiResponse("201", "Data inserted Successfully.");
        }
        return new ApiResponse("400", "Data did not insert.");
    }

    @PutMapping
    public ApiResponse updateRole(@RequestBody Role role) {
        if (roleService.updateRole(role)) {
            return new ApiResponse("200", "Data updated Successfully.");
        }
        return new ApiResponse("400", "Data did not update.");
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable Long id) {
        if (roleService.deleteById(id)) {
            return new ApiResponse("200", "Id " + id + " deleted.");
        }
        return new ApiResponse("400", "ID " + id + " did not deleted.");
    }

    @GetMapping("/role/{role}")
    public ApiResponse getByRole(@PathVariable String role){
        return new ApiResponse("200","role" ,roleService.getByRole(role));
    }
}
