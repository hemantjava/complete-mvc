package com.hemant.complete.mvc.mapper;

import com.hemant.complete.mvc.dto.StudentDTO;
import com.hemant.complete.mvc.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDTO studentDTO);

    StudentDTO toDto(Student student);
}
