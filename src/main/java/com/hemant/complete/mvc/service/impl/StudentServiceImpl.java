package com.hemant.complete.mvc.service.impl;

import com.hemant.complete.mvc.dto.StudentDTO;
import com.hemant.complete.mvc.exception.UserNotFoundException;
import com.hemant.complete.mvc.mapper.StudentMapper;
import com.hemant.complete.mvc.repository.StudentRepository;
import com.hemant.complete.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public StudentDTO getStudent(Long id) {
        return studentRepository.findById(id).map(studentMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("Could not find student:" + id));
    }

    @Override
    public boolean deleteStudent(Long rollNumber) {
        return Optional.of(rollNumber).filter(studentRepository::existsById)
                .map(id -> {
                    studentRepository.deleteById(rollNumber);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("Could not find student:" + rollNumber));
    }

    @Override
    public List<StudentDTO> getStudentList() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Long addStudent(StudentDTO student) {

        return studentRepository.save(studentMapper.toEntity(student)).getId();
    }

    @Override
    public Long updateStudent(StudentDTO studentDTO) {
        return Optional.of(studentDTO).filter(student -> studentRepository.existsById(student.getId()))
                .map(st -> studentRepository.save(studentMapper.toEntity(st)).getId())
                .orElseThrow(() -> new UserNotFoundException("Student not found:" + studentDTO.getId()));
    }

}
