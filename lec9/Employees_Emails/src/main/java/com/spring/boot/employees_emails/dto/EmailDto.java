package com.spring.boot.employees_emails.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {

    private Long id;

    @NotNull(message = "Email type must not be null")
    @NotEmpty(message = "Email type must not be empty")
    private String name;

    @NotNull(message = "Content must not be null")
    @Email(message = "Content must be a valid email")
    private String content;

    private EmployeeDto employee;
}
