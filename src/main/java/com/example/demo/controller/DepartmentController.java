package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments(){
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long DepartmentId){
        return departmentService.fetchDepartmentById(DepartmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchByDepartmentName(@PathVariable("name") String departmentName){
        return departmentService.fetchByDepartmentName(departmentName);
    }

    @DeleteMapping("/departments/{id}")
    public String  deleteDepartmentById(@PathVariable("id") Long DepartmentId){
         departmentService.deleteDepartmentById(DepartmentId);
        return "Record deleted successfully";
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

}
