package com.spring.boot.uni.service;

import com.spring.boot.uni.model.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
}
