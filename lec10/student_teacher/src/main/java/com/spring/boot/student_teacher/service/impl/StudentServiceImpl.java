package com.spring.boot.student_teacher.service.impl;

import com.spring.boot.student_teacher.dto.StudentDTO;
import com.spring.boot.student_teacher.mapper.StudentMapper;
import com.spring.boot.student_teacher.model.Student;
import com.spring.boot.student_teacher.repo.StudentRepository;
import com.spring.boot.student_teacher.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return  studentMapper.toDTO(studentRepository.getOne(id));
    }
}
