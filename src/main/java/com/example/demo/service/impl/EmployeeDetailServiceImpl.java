package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailServiceImpl implements DetailService {

    private final UserDao userDao;

    @Autowired
    public EmployeeDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Employee getDetailsById(String id) {
        return userDao.getDetails(id);
    }
}
