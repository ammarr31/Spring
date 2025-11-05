package com.spring.boot.uni.service;

import com.spring.boot.uni.dto.StudentDTO;
import com.spring.boot.uni.model.Student;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO registerStudentToCourse(Long studentId, Long courseId);
}
