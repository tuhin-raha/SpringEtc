package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeDetailServiceImpl implements DetailService {

    private final UserDao userDao;

    @Autowired
    public EmployeeDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Employee getDetailsById(String id) {
        // return Optional<Employee>
        // return userDao.getDetails(id);
        Optional<Employee> details = userDao.findById(id);
        return details.get();

    }

    @Transactional
    @Override
    public Employee createDetails(Employee newEmployee) {
        return userDao.save(newEmployee);
    }
}
