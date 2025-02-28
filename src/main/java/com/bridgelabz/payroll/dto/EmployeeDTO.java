package com.bridgelabz.payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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

    @Min(value = 500, message = "Salary should be more than 500")
    private double salary;

//    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "start date needed")
//    @PastOrPresent(message = "Start date should be past or present")
    private LocalDate startDate;

    @Pattern(regexp = "male|female", message = "Gender needs male or female")
    private String gender;

    @NotBlank(message = "Note should not empty")
    private String note;

    @NotBlank(message = "Profile picture should be not null")
    private String profilePicture;

    @NotNull(message = "department should be needed")
    private  String department;


}
