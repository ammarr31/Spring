package com.spring.boot.uni.service;

import com.spring.boot.uni.dto.CourseDTO;
import com.spring.boot.uni.model.Course;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);
    List<CourseDTO> getAllCourses();
    Course getCourseById(Long id);
    Course assignInstructor(Long courseId, Long instructorId);
}
