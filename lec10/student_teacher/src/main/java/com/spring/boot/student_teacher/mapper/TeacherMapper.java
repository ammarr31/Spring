package com.spring.boot.student_teacher.mapper;

import com.spring.boot.student_teacher.dto.TeacherDTO;
import com.spring.boot.student_teacher.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "students", source = "students")
    TeacherDTO toDTO(Teacher teacher);
    Teacher toEntity(TeacherDTO teacherDTO);
}
