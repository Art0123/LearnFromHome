package com.art0123.LearnFromHome.repository;

import com.art0123.LearnFromHome.entity.Class;
import com.art0123.LearnFromHome.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByUsername(String username);
   // Optional<Student> findStudentByUsername(String username);
    List<Student> findStudentsByClassId(Class classId);
    List<Student> findStudentsByClassIdClassName(String name);

}
