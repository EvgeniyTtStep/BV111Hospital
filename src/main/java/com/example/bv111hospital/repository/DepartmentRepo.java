package com.example.bv111hospital.repository;

import com.example.bv111hospital.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {




}
