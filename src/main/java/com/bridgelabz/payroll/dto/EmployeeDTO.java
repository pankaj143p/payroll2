package com.bridgelabz.payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EmployeeDTO {

    @NotNull(message = "Name can not be null")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    private String name;

    @Min(value = 1, message = "Salary should be a positive number")
    private double salary;

    private LocalDate startDate;

    private String gender;

    private String note;

    private String profilePicture;

    private  List<String>department;


}
