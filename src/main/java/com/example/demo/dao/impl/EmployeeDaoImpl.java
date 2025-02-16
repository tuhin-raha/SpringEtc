package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Primary
@Repository
public class EmployeeDaoImpl implements UserDao {
    @Autowired
    private EntityManager dbEntityManager;

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(dbEntityManager.find(Employee.class, id));

    }
}
