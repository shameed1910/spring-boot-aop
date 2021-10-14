package com.example.aop.springaop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String department;
}
