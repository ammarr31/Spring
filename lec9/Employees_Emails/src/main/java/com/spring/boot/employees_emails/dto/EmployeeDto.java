package com.spring.boot.employees_emails.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EmployeeDto {

    private Long id;

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private int age;

    @DecimalMin(value = "5001", message = "Salary must be greater than 5000")
    @DecimalMax(value = "9999", message = "Salary must be less than 10000")
    private double salary;

    private List<EmailDto> emails;
}
