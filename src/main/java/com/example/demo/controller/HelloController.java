package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HelloController {

    private DetailService detailService;

    @Autowired
    public HelloController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeWithPathParam(@PathVariable Integer id){
        return detailService.getDetailsById(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee newEmployee){
        System.out.println(newEmployee.toString() + newEmployee.getProfileOfEmployee().toString() + newEmployee.getProjects().toString());
        return detailService.createDetails(newEmployee);
    }

    @DeleteMapping ("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        return detailService.deleteDetails(employeeId);
    }

    @PutMapping ("/employees")
    public String modifyEmployee(@RequestBody Employee employeeToBeModified){
        return detailService.modifyDetails(employeeToBeModified);
    }

}
