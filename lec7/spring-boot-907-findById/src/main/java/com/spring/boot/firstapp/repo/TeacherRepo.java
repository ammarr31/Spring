package com.spring.boot.firstapp.repo;

import com.spring.boot.firstapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}