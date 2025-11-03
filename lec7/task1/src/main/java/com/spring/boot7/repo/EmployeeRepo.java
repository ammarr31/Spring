package com.spring.boot7.repo;

import com.spring.boot7.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo  extends JpaRepository<Employee,Long> {
    List<Employee> findEmployeesByNameIgnoreCaseStartingWith(String name);

    //@Query(value = "SELECT * FROM employee WHERE name LIKE :name", nativeQuery = true)
    @Query("SELECT e FROM Employee e WHERE e.name LIKE :name")
    List<Employee> searchEmployeesByName(String name);
}
