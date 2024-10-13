package com.hemant.complete.mvc.repository;

import com.hemant.complete.mvc.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNumber(Long rollNumber);
    boolean existsByRollNumber(Long integer);
    @Transactional
    @Query(value = "DELETE FROM student WHERE rollNumber ?",nativeQuery = true)
    @Modifying
    boolean deleteByRollNumber(@Param("rollNumber") int rollNumber);
}
