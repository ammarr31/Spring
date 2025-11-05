package com.spring.boot.uni.controller;

import com.spring.boot.uni.dto.StudentDTO;
import com.spring.boot.uni.model.Student;
import com.spring.boot.uni.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add-student")
    public StudentDTO addStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public StudentDTO registerStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.registerStudentToCourse(studentId, courseId);
    }


}
