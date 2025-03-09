package com.bridgelabz.payroll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private String gender;

//    @Column(nullable = false)
    private LocalDate StartDate;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private String profilePicture;

    @ElementCollection
    private String [] departments;
}
