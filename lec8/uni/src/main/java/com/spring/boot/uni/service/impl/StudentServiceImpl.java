package com.spring.boot.uni.service.impl;

import com.spring.boot.uni.dto.CourseDTO;
import com.spring.boot.uni.dto.StudentDTO;
import com.spring.boot.uni.model.Course;
import com.spring.boot.uni.model.Student;
import com.spring.boot.uni.repo.CourseRepository;
import com.spring.boot.uni.repo.StudentRepository;
import com.spring.boot.uni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        Student student = new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getEmail(), studentDTO.getPassword(),null);
        student =  studentRepository.save(student);
        studentDTO.setId(student.getId());
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail(), null , null)).collect(Collectors.toList());

    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        StudentDTO studentDTO = new StudentDTO(student.get().getId(), student.get().getName(), student.get().getEmail(), null, (Set<CourseDTO>) student.get().getCourses().stream().map(course -> course.getTitle()));
        return studentDTO;
    }

    @Override
    public StudentDTO registerStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (student.getCourses().contains(course)) {
            throw new RuntimeException("Student " + student.getName() + " is already registered in course " + course.getTitle());
        }

        student.getCourses().add(course);
        Student savedStudent = studentRepository.save(student);

        Set<CourseDTO> courseDTOs = savedStudent.getCourses().stream()
                .map(c -> new CourseDTO(c.getId(), c.getTitle(),c.getDescription(),null))
                .collect(Collectors.toSet());

        StudentDTO dto = new StudentDTO(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getEmail(),
                savedStudent.getPassword(),
                courseDTOs
        );

        return dto;
    }




}
