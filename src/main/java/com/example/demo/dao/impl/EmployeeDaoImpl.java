package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements UserDao {
    @Autowired
    private EntityManager dbEntityManager;

    @Override
    public Employee getDetails(String id) {
        return dbEntityManager.find(Employee.class, id);

    }
}
