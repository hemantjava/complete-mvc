package com.hemant.complete.mvc.service.impl;

import com.hemant.complete.mvc.dto.StudentDTO;
import com.hemant.complete.mvc.entity.Student;
import com.hemant.complete.mvc.exception.UserNotFoundException;
import com.hemant.complete.mvc.mapper.StudentMapper;
import com.hemant.complete.mvc.repository.StudentRepository;
import com.hemant.complete.mvc.service.test.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;
    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void getStudent() {
        StudentDTO studentDTO = Data.getStudentDTO();
        Student student = Data.getStudent();
        when(studentMapper.toDto(any())).thenReturn(studentDTO);
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        StudentDTO studentDTO1 = studentService.getStudent(anyLong());
        Assertions.assertEquals(studentDTO.getId(), studentDTO1.getId());
    }

    @Test
    void getStudentException() {
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> studentService.getStudent(anyLong()));
        Assertions.assertTrue(exception.getMessage().contains("Could not find student"));
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void getStudentList() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void updateStudent() {
    }
}