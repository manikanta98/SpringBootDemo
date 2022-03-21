package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department) {
        Department depDb = departmentRepository.findById(department.getDepartmentId()).get();

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress()) ){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode()) ){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName()) ){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchByDepartmentName(String departmentName) {
        return departmentRepository.findBydepartmentName(departmentName);
    }

}
