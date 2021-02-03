package com.art0123.LearnFromHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/teachers")
    public String showTeacherPage() {
        return "teachers-page";
    }

    @GetMapping("/students")
    public String showStudentPage() {
        return "students-page";
    }
}
