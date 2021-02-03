package com.art0123.LearnFromHome.repository;

import com.art0123.LearnFromHome.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findStudentByUsername(String username);
}
