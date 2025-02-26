package com.bridgelabz.payroll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity // Marks this class as a JPA entity
@Table(name = "employee") // Defines the table name in the database
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all fields
@ToString // Generates the toString() method for the class
public class Employee {

    @Id // Specifies the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID will be auto-generated by the database
    private @Getter @Setter int id;

    @NotNull(message = "Name can not be null") // Validates that the name field cannot be null
    private @Getter @Setter String name;

    @Min(value = 1, message = "Salary should be a positive number") // Ensures the salary is greater than or equal to 1
    private @Getter @Setter double salary;

    private @Getter @Setter LocalDate startDate; // Stores the start date of the employee

    private @Getter @Setter String gender; // Gender of the employee
}
