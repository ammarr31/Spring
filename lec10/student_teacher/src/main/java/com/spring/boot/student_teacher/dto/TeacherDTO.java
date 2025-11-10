package com.spring.boot.student_teacher.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;

}
