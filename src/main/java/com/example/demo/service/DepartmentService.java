package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchAllDepartments();


   public Department fetchDepartmentById(Long departmentId);

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Department department);

   public Department fetchByDepartmentName(String departmentName);
}
