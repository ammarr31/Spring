package com.spring.boot.employees_emails.service.impl;

import com.spring.boot.employees_emails.dto.EmployeeDto;
import com.spring.boot.employees_emails.mapper.EmployeeMapper;
import com.spring.boot.employees_emails.model.Employee;
import com.spring.boot.employees_emails.repo.EmployeeRepo;
import com.spring.boot.employees_emails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .map(employeeMapper::toDto)
                .orElse(null);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        return employeeMapper.toDto(employeeRepo.save(employeeMapper.toEntity(dto)));
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto dto) {
        return employeeMapper.toDto(employeeRepo.save(employeeMapper.toEntity(dto)));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
        return employeeRepo.findByIdIn(ids).stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByNames(List<String> names) {
        return employeeRepo.findByNameIn(names).stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }
}
