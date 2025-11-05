package com.spring.boot.uni.service.impl;

import com.spring.boot.uni.dto.CourseDTO;
import com.spring.boot.uni.model.Course;
import com.spring.boot.uni.model.Instructor;
import com.spring.boot.uni.repo.CourseRepository;
import com.spring.boot.uni.repo.InstructorRepository;
import com.spring.boot.uni.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course(courseDTO.getId(),courseDTO.getTitle(),courseDTO.getDescription(),null,null);
        courseRepository.save(course);
        courseDTO.setId(course.getId());
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(course -> new CourseDTO(course.getId(),course.getTitle(),course.getDescription(), null)).collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course assignInstructor(Long courseId, Long instructorId) {
        Course course = getCourseById(courseId);
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }
}
