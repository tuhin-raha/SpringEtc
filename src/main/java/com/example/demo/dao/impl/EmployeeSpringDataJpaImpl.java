package com.example.demo.dao.impl;

import com.example.demo.entity.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface EmployeeSpringDataJpaImpl extends JpaRepository<Employee, Integer>{
}
