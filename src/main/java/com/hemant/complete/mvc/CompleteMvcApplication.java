package com.hemant.complete.mvc;

import com.hemant.complete.mvc.entity.Student;
import com.hemant.complete.mvc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CompleteMvcApplication implements CommandLineRunner {


    private final StudentRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(CompleteMvcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setAge(32);
        student.setRollNumber(1232432134L);
        student.setName("Hemant");

        System.out.println("Student saved :" + repository.save(student));
    }
}
