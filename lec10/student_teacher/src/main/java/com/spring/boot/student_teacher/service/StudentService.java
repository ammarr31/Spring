package com.spring.boot.student_teacher.service;

import com.spring.boot.student_teacher.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
}
