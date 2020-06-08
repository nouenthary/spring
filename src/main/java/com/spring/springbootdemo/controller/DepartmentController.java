package com.spring.springbootdemo.controller;

import com.spring.springbootdemo.model.Department;
import com.spring.springbootdemo.model.api.ApiResponse;
import com.spring.springbootdemo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ApiResponse getAllDepartment() {
        List<Department> departments = departmentService.findAll();
        if (departments.size() > 0) {
            return new ApiResponse("200", "Data retrieve successfully.", departments);
        } else {
            return new ApiResponse("400", "Data not found.");
        }
    }

    @GetMapping("/{id}")
    public ApiResponse getDepartmentById(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            return new ApiResponse("200", "Data retrieve successfully.", department);
        } else {
            return new ApiResponse("400", "Data not found.");
        }
    }

    @PostMapping
    public ApiResponse addDepartment(@RequestBody Department department) {
        if (departmentService.addDepartment(department)) {
            return new ApiResponse("201", "Data inserted Successfully.");
        }
        return new ApiResponse("400", "Data did not insert.");
    }

    @PutMapping
    public ApiResponse updateDepartment(@RequestBody Department department) {
        if (departmentService.updateDepartment(department)) {
            return new ApiResponse("200", "Data updated Successfully.");
        }
        return new ApiResponse("400", "Data did not update.");
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable("id") Long id) {
        if (departmentService.deleteById(id)) {
            return new ApiResponse("200", "Id " + id + " deleted.");
        }
        return new ApiResponse("400", "ID " + id + " did not deleted.");
    }

    @PatchMapping("/{id}")
    public ApiResponse restoreById(@PathVariable("id") Long id) {
        if (departmentService.restoreById(id)) {
            return new ApiResponse("200", "Id " + id + " restored.");
        }
        return new ApiResponse("400", "ID " + id + " did not restored.");
    }
    
   

}
