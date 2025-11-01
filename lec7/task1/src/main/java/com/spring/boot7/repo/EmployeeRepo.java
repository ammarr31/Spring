package com.spring.boot7.repo;

import com.spring.boot7.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
}
