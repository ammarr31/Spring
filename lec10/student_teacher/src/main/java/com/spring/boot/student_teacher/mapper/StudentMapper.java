package com.spring.boot.student_teacher.mapper;

import com.spring.boot.student_teacher.dto.StudentDTO;
import com.spring.boot.student_teacher.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
}
