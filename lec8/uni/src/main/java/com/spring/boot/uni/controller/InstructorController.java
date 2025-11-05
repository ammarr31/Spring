package com.spring.boot.uni.controller;

import com.spring.boot.uni.model.Instructor;
import com.spring.boot.uni.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/add-instructor")
    public Instructor addInstructor(@RequestBody @Valid Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }
}
