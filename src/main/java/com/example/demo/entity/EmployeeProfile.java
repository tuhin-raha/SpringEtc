package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employeeprofile")
public class EmployeeProfile {

    @Id
    @Column(name="idProfile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;

    @Column(name="address")
    private String employeeAddress;

    @Column(name="phoneNumber")
    private String employeePhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmployee")
    @JsonIgnore
    private Employee employee;

    /*  1. You don't mention the foreign key explicitly
        2. under mapped by, you mention the field name in the owning relationship
     */

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeProfile that)) return false;
        return Objects.equals(getProfileId(), that.getProfileId()) && Objects.equals(getEmployeeAddress(), that.getEmployeeAddress()) && Objects.equals(getEmployeePhoneNumber(), that.getEmployeePhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileId(), getEmployeeAddress(), getEmployeePhoneNumber());
    }

    @Override
    public String toString() {
        return "EmployeeProfile{" +
                "profileId=" + profileId +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                '}';
    }
}
