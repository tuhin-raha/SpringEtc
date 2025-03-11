package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employeeprofile")
public class EmployeeProfile {

    @Id
    @Column(name="idProfile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;

    @Column(name="address")
    private String employeeAddress;

    @Column(name="phoneNumber")
    private String employeePhoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmployee", referencedColumnName = "id")
    private Employee employee;

    /*  1. You don't mention the foreign key explicitly
        2. under mapped by, you mention the field name in the owning relationship
     */

}
