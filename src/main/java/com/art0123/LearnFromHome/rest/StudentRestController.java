package com.art0123.LearnFromHome.rest;

import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.service.StudentService;
import com.art0123.LearnFromHome.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return userDetailsService.findAllStudents();
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        student.setId(0);
        studentService.saveStudent(student);

        return student;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            throw new RuntimeException("Student with id: '" + id + "' - not found");
        }

        studentService.deleteStudentById(id);
        System.out.println("Deleted student with id: " + id);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            throw new RuntimeException("Student with id: '" + id + "' - not found");
        }
        return student;
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }
}
