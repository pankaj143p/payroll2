package com.bridgelabz.payroll.exception;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {

    private String Message;
    private int status;
    private long timestamp;

    public ErrorResponse(String string, int value) {
    }

    public ErrorResponse(String validationFailed, List<String> errorMessages, int value) {
    }
}
