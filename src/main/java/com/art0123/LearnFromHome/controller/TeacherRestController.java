package com.art0123.LearnFromHome.controller;

import com.art0123.LearnFromHome.entity.Teacher;
import com.art0123.LearnFromHome.service.TeacherService;
import com.art0123.LearnFromHome.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return userDetailsService.findAllTeachers();
    }

    @PostMapping("/teachers")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        teacher.setId(0);
        teacherService.saveTeacher(teacher);

        return teacher;
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacherById(id);

        if (teacher == null) {
            throw new RuntimeException("Teacher with id: '" + id + "' - not found");
        }

        teacherService.deleteTeacherById(id);
        System.out.println("Deleted teacher with id: " + id);
    }

    @GetMapping("/teachers/{id}")
    public Teacher getStudentById(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacherById(id);

        if (teacher == null) {
            throw new RuntimeException("Teacher with id: '" + id + "' - not found");
        }
        return teacher;
    }

    @PutMapping("/teachers")
    public void updateStudent(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
    }
}
