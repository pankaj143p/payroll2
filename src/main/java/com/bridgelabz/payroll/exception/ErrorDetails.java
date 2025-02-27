package com.bridgelabz.payroll.exception;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {
    @Getter @Setter
    private String Field;

    @Getter @Setter
    private String Message;
}
