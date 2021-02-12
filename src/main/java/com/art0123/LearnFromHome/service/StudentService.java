package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.dao.StudentDAOImpl;
import com.art0123.LearnFromHome.dto.StudentDto;
import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.entity.StudentEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
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

    @Transactional
    public void saveRegisteredStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setUsername(studentDto.getUsername());
        student.setPassword(studentDto.getPassword());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentEmailClass(new StudentEmail(studentDto.getStudentEmail(), studentDto.getPassword()));
        student.setRoleClass(userDetailsService.findRoleByName("ROLE_STUDENT"));
        student.setUserClass(userDetailsService.findStudentClassByName(studentDto.getStudentClass()));

        studentDAO.saveStudent(student);
    }

    private boolean emailExists(String email) {
        return userDetailsService.findStudentByEmail(email) != null;
    }
}
