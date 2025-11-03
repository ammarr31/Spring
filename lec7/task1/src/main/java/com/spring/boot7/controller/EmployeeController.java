package com.spring.boot7.controller;

import com.spring.boot7.model.Employee;
import com.spring.boot7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/save/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PostMapping("/bulksave")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.bulkSave(employees);
    }

    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @PutMapping("/bulkupdate")
    public List<Employee> updateEmployees(@RequestBody List<Employee> employees) {
        return employeeService.bulkUpdate(employees);
    }

    @DeleteMapping("/delete/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @DeleteMapping("/bulkdelete")
    public void deleteEmployees(@RequestBody List<Long> ids) {
        employeeService.bulkDelete(ids);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployees(name);
    }

}
