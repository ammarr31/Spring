package com.spring.boot.student_teacher.mapper;

import com.spring.boot.student_teacher.dto.StudentDTO;
import com.spring.boot.student_teacher.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-08T17:10:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );

        return studentDTO;
    }

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setName( studentDTO.getName() );

        return student;
    }
}
