package com.spring.boot.firstapp.service.impl;

import com.spring.boot.firstapp.model.Teacher;
import com.spring.boot.firstapp.repo.TeacherRepo;
import com.spring.boot.firstapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        if (Objects.nonNull(teacher.getId())) {
            throw new IllegalArgumentException("teacher must have ID.");
        }

        if (Objects.isNull(teacher.getName())) {
            throw new IllegalArgumentException("name must can't be null.");
        }

        if (Objects.isNull(teacher.getUserName())) {
            throw new IllegalArgumentException("username can't be null.");
        }

        if (Objects.isNull(teacher.getPassword())) {
            throw new IllegalArgumentException("password can't be null.");
        }
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if(Objects.isNull(teacher.getId()))
        {
            throw new IllegalArgumentException("u must write teacher ID.");
        }
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        if(Objects.isNull(id))
        {
            throw new IllegalArgumentException("u must write teacher ID.");
        }
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher findTeacherById(Long id) {
        if(Objects.isNull(id))
        {
            throw new IllegalArgumentException("u must write teacher ID.");
        }
        return teacherRepo.findById(id).orElse(null);
    }
}
