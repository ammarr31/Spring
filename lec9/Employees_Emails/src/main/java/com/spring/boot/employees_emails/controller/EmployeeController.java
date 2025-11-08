package com.spring.boot.employees_emails.controller;

import com.spring.boot.employees_emails.dto.EmployeeDto;
import com.spring.boot.employees_emails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dto) {
        return ResponseEntity.status(201).body(employeeService.createEmployee(dto));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/by-ids")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(employeeService.getEmployeesByIds(ids));
    }

    @PostMapping("/by-names")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(employeeService.getEmployeesByNames(names));
    }
}
