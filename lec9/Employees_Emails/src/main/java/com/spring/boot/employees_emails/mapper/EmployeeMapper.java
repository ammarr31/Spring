package com.spring.boot.employees_emails.mapper;

import com.spring.boot.employees_emails.dto.EmployeeDto;
import com.spring.boot.employees_emails.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto dto);
}
