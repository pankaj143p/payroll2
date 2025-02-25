package com.bridgelabz.payroll.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int id;

    @NotNull(message = "Name can not be null")
    private @Getter @Setter String name;

    @Min(value = 1, message = "Salary should be a positive number")
    private @Getter @Setter double salary;

    private @Getter @Setter LocalDate startDate;

    private @Getter @Setter String gender;


}