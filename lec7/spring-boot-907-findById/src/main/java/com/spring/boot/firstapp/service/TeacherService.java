package com.spring.boot.firstapp.service;

import com.spring.boot.firstapp.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllTeachers();
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Teacher findTeacherById(Long id);

}
