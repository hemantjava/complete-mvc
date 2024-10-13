package com.hemant.complete.mvc.service;

import com.hemant.complete.mvc.dto.StudentDTO;

import java.util.List;


public interface StudentService {
    StudentDTO getStudent(Long id);

    boolean deleteStudent(Long id);

    List<StudentDTO> getStudentList();

    Long addStudent(StudentDTO student);

    Long updateStudent(StudentDTO studentDTO);
}
