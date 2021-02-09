package com.art0123.LearnFromHome.dao;

import com.art0123.LearnFromHome.entity.Student;

public interface StudentDAO {
    void saveStudent(Student student);
    void deleteStudentById(int id);
    Student findStudentById(int id);
}
