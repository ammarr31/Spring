package com.spring.boot.student_teacher.controller;

import com.spring.boot.student_teacher.dto.TeacherDTO;
import com.spring.boot.student_teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }
}
