package com.art0123.LearnFromHome.repository;

import com.art0123.LearnFromHome.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherByUsername(String username);
    Teacher findTeachersByUserClass_ClassName(String className);
}
