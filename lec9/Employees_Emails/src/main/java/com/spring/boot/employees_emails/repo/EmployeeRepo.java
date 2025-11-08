package com.spring.boot.employees_emails.repo;

import com.spring.boot.employees_emails.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByIdIn(List<Long> ids);

    List<Employee> findByNameIn(List<String> names);
}
