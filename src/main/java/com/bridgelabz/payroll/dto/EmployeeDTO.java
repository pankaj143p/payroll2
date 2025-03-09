package com.bridgelabz.payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;

    @DecimalMin(value = "0.0", message = "Salary must be greater than 0")
    @DecimalMax(value = "9999999.0", message = "Salary is too high")
    private Double salary;

    @NotBlank
    private String gender;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate StartDate;

    @NotBlank(message = "Note is empty")
    private String note;

    @NotBlank(message = "Profile picture is empty")
    private String profilePicture;

    @NotEmpty(message = "Department(s) cannot be empty")
    private String [] departments;
}
