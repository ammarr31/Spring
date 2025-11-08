package com.spring.boot.employees_emails.service;

import com.spring.boot.employees_emails.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto dto);
    EmployeeDto updateEmployee(EmployeeDto dto);
    void deleteEmployee(Long id);
    List<EmployeeDto> getEmployeesByIds(List<Long> ids);
    List<EmployeeDto> getEmployeesByNames(List<String> names);
}
