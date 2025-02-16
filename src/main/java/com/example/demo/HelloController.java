package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class HelloController {

    private DetailService detailService;

    @Autowired
    public HelloController(DetailService detailService) {
        this.detailService = detailService;
    }
    /*@GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }*/

    /*@GetMapping("/employees")
    public String getAllEmployees(){ return "All Employees Returned";}*/


    @GetMapping("/employees/{id}")
    public Employee getEmployeeWithPathParam(@PathVariable String id){
        //return new ResponseEntity<Employee>(detailService.getDetailsById(id), HttpStatus.OK);
        return detailService.getDetailsById(id);

    }

/*    @GetMapping("/employees")
    public String getEmployeeWithQueryParam(@RequestParam(required = false) String name){ return "Query Param Employee Returned" + name;}

    @PostMapping("/employees")
    public String postEmployeeWithRequestBody(@RequestBody String name){ return "Request Param Employee Returned" + name;}

    @PostMapping("/employeesHeader")
    public String postEmployeeWithHeader(@RequestHeader Map<String, String> headers, @RequestHeader String name){ return "Header Employee Returned " + name + headers;}*/


}
