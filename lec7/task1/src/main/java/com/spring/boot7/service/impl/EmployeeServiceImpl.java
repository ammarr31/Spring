package com.spring.boot7.service.impl;

import com.spring.boot7.model.Employee;
import com.spring.boot7.repo.EmployeeRepo;
import com.spring.boot7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> bulkSave(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> bulkUpdate(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void bulkDelete(List<Long> ids) {
         employeeRepo.deleteAllById(ids);
    }
}
