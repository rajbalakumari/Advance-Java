package com.nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee_details")
@Data
public class Employee {

    @Id
    private int id;

    private String name;

    private String address;

    private String companyName;
}
