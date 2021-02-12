package com.art0123.LearnFromHome.controller;

import com.art0123.LearnFromHome.entity.Teacher;
import com.art0123.LearnFromHome.security.CurrentUser;
import com.art0123.LearnFromHome.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MyController {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public MyController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/teachers")
    public String showTeacherPage(Model theModel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser teacher = (CurrentUser)auth.getPrincipal();

        theModel.addAttribute("students", this.userDetailsService.findStudentsByClassName(teacher.getClassName()));

        return "teachers-page";
    }

    @GetMapping("/students")
    public String showStudentPage(Model theModel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser student = (CurrentUser)auth.getPrincipal();
        String className = student.getClassName();
        Teacher teacher = userDetailsService.findTeacherByClassName(className);

        theModel.addAttribute("myTeacher", teacher);

        return "students-page";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }
}
