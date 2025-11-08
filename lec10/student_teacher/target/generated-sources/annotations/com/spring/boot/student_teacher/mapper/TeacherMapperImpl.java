package com.spring.boot.student_teacher.mapper;

import com.spring.boot.student_teacher.dto.StudentDTO;
import com.spring.boot.student_teacher.dto.TeacherDTO;
import com.spring.boot.student_teacher.model.Student;
import com.spring.boot.student_teacher.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-08T16:56:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDTO toDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setStudents( studentListToStudentDTOList( teacher.getStudents() ) );
        teacherDTO.setId( teacher.getId() );
        teacherDTO.setName( teacher.getName() );

        return teacherDTO;
    }

    @Override
    public Teacher toEntity(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDTO.getId() );
        teacher.setName( teacherDTO.getName() );
        teacher.setStudents( studentDTOListToStudentList( teacherDTO.getStudents() ) );

        return teacher;
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );

        return studentDTO;
    }

    protected List<StudentDTO> studentListToStudentDTOList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<StudentDTO> list1 = new ArrayList<StudentDTO>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToStudentDTO( student ) );
        }

        return list1;
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setName( studentDTO.getName() );

        return student;
    }

    protected List<Student> studentDTOListToStudentList(List<StudentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Student> list1 = new ArrayList<Student>( list.size() );
        for ( StudentDTO studentDTO : list ) {
            list1.add( studentDTOToStudent( studentDTO ) );
        }

        return list1;
    }
}
