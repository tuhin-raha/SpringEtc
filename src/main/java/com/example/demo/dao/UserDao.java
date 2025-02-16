package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.Optional;

public interface UserDao {


    //Optional<Employee> getDetails(String id);

    Optional<Employee> findById(String id);
}
