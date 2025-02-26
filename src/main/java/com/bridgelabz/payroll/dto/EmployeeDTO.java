package com.bridgelabz.payroll.dto;

import lombok.Getter;
import lombok.Setter;
// dto 
public class EmployeeDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private double salary;

    @Getter @Setter
    private String gender;

    // Constructor
    public EmployeeDTO() {}

    public EmployeeDTO(String name, double salary, String gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }
}
