package com.spring.springbootdemo.services.Imp;

import com.spring.springbootdemo.model.Department;
import com.spring.springbootdemo.repository.imp.DepartmentRepositoryImp;
import com.spring.springbootdemo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepositoryImp departmentRepositoryImp;

    @Override
    public boolean addDepartment(Department department) {
        return departmentRepositoryImp.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentRepositoryImp.updateDepartment(department);
    }

    @Override
    public boolean deleteById(Long id) {
        return departmentRepositoryImp.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepositoryImp.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepositoryImp.findAll();
    }

    @Override
    public boolean restoreById(Long id) {
        return departmentRepositoryImp.restoreById(id);
    }
}
