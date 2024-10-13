package com.hemant.complete.mvc.controller;

import com.hemant.complete.mvc.dto.StudentDTO;
import com.hemant.complete.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students/")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentByRollNumber(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @PutMapping
    public ResponseEntity<Long> updateStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.updateStudent(studentDTO));
    }

    @PostMapping
    public ResponseEntity<Long> AddStudent(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.addStudent(studentDTO));
    }


}
