package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface DetailService {

    public Employee getDetailsById(Integer id);

    public Employee createDetails(Employee newEmployee);

    public String deleteDetails(Integer toBeDeleted);

    public String modifyDetails(Employee employeeToBeModified);
}
