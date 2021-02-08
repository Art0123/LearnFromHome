package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.dao.StudentDAOImpl;
import com.art0123.LearnFromHome.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDAOImpl studentDAO;

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public void deleteStudentById(int id) {
        studentDAO.deleteStudentById(id);
    }

    public Student getStudentById(int id) {
        return studentDAO.findStudentById(id);
    }
}
