package com.spring.boot.uni.controller;

import com.spring.boot.uni.dto.CourseDTO;
import com.spring.boot.uni.model.Course;
import com.spring.boot.uni.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-course")
    public CourseDTO addCourse(@RequestBody @Valid CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping("/courses")
    public List<CourseDTO> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/course/{courseId}/instructor/{instructorId}")
    public Course assignInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        return courseService.assignInstructor(courseId, instructorId);
    }
}
