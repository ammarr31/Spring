package com.spring.boot.student_teacher.service.impl;

import com.spring.boot.student_teacher.dto.TeacherDTO;
import com.spring.boot.student_teacher.mapper.TeacherMapper;
import com.spring.boot.student_teacher.model.Student;
import com.spring.boot.student_teacher.model.Teacher;
import com.spring.boot.student_teacher.repo.StudentRepository;
import com.spring.boot.student_teacher.repo.TeacherRepository;
import com.spring.boot.student_teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        return  teacherMapper.toDTO(teacherRepository.getOne(id));
    }
}
