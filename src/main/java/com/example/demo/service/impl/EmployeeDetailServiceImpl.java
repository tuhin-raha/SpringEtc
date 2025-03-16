package com.example.demo.service.impl;

import com.example.demo.dao.impl.EmployeeSpringDataJpaImpl;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class EmployeeDetailServiceImpl implements DetailService {

    private final EmployeeSpringDataJpaImpl employeeSpringDataJpa;

    @Autowired
    public EmployeeDetailServiceImpl(EmployeeSpringDataJpaImpl employeeSpringDataJpa) {
        this.employeeSpringDataJpa = employeeSpringDataJpa;
    }

    @Override
    public Employee getDetailsById(Integer id) {
        Optional<Employee> details = employeeSpringDataJpa.findById(id);
        Employee nothingFound = details.orElseThrow(() -> new ResourceNotFoundException("nothing found"));
        return nothingFound;
    }

    @Transactional
    @Override
    public Employee createDetails(Employee newEmployee) {
        return employeeSpringDataJpa.saveAndFlush(newEmployee);
    }

    @Transactional
    @Override
    public String deleteDetails(Integer employeeToBeDeleted) {
        employeeSpringDataJpa.deleteById(employeeToBeDeleted);
        return "employee has been deleted";
    }

    @Transactional
    @Override
    public String modifyDetails(Employee employeeToBeModified) {
        Employee toBeModified = employeeSpringDataJpa.findById(employeeToBeModified.getId()).get();
        toBeModified.setName(employeeToBeModified.getName());
        toBeModified.setRole(employeeToBeModified.getRole());
        employeeSpringDataJpa.save(toBeModified);
        return "details have been modified";
    }
}
