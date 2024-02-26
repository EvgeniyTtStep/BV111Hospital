package com.example.bv111hospital.service;

import com.example.bv111hospital.entity.Department;
import com.example.bv111hospital.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;


    @Autowired
    public void setDepartmentRepo(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    public List<Department> getAll() {
        return departmentRepo.findAll();
    }


}
