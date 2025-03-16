package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employee")
public class Employee{
    @Id
    @Column(name="idEmployee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="name")
    private  String name;
    @Column(name="role")
    private String role;

    @OneToOne (mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmployeeProfile profileOfEmployee;

    @OneToMany (mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;

    public Employee(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
        if(projects != null){
            projects.forEach(x-> x.setEmployee(this));
        }
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmployeeProfile getProfileOfEmployee() {
        return profileOfEmployee;
    }

    public void setProfileOfEmployee(EmployeeProfile profileOfEmployee) {
        this.profileOfEmployee = profileOfEmployee;
        if(profileOfEmployee != null){
            profileOfEmployee.setEmployee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getRole(), employee.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole());
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", roles=" + role + '}';
    }
}
