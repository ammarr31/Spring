package com.spring.boot.student_teacher.service;

import com.spring.boot.student_teacher.dto.TeacherDTO;
import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();
    TeacherDTO getTeacherById(Long id);
}
