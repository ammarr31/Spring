package com.spring.boot7.service;

import com.spring.boot7.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeService{
    List<Employee> findAllEmployees();
    Employee save(Employee employee);
    // bulk save
    List<Employee> bulkSave(List<Employee> employees);

    Employee update(Employee employee);
    // bulk
    List<Employee> bulkUpdate(List<Employee> employees);

    void delete(Long id);
    // bulk
    void bulkDelete(List<Long> ids);

    List<Employee> searchEmployees(String name);

}
