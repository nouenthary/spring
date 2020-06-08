package com.spring.springbootdemo.services;

import com.spring.springbootdemo.model.Department;

import java.util.List;

public interface DepartmentService {

    boolean addDepartment(Department department);

    boolean updateDepartment(Department department);

    boolean deleteById(Long id);

    Department findById(Long id);

    List<Department> findAll();

    boolean restoreById(Long id);
}
