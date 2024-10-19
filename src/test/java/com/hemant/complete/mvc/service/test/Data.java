package com.hemant.complete.mvc.service.test;

import com.hemant.complete.mvc.dto.StudentDTO;
import com.hemant.complete.mvc.entity.Student;
import org.instancio.Instancio;

import java.util.List;
import java.util.stream.Stream;

public class Data {

    public static List<StudentDTO> getStudentDTOList() {
        return Instancio.ofList(StudentDTO.class).size(10).create();
    }

    public static Stream<StudentDTO> getStudentDTOStream() {
        return Instancio.of(StudentDTO.class).stream().limit(10);
    }

    public static StudentDTO getStudentDTO() {
        return Instancio.create(StudentDTO.class);
    }
    public static Student getStudent() {
        return Instancio.create(Student.class);
    }

}
