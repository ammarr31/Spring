package com.spring.boot.firstapp.controller;

import com.spring.boot.firstapp.model.Teacher;
import com.spring.boot.firstapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll() {
        return teacherService.findAllTeachers();
    }

    @PostMapping("/save/teacher")
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/edit/teacher")
    public Teacher update(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/delete/teacher/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/teacher/{id}")
    public Teacher findTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }
}
