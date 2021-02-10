package com.art0123.LearnFromHome.repository;

import com.art0123.LearnFromHome.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByUsername(String username);
    List<Student> findStudentsByUserClass_ClassName(String name);
    Student findStudentByStudentEmailClass_EmailName(String email);
}
