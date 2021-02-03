package com.art0123.LearnFromHome.controller;

import com.art0123.LearnFromHome.entity.Class;
import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.service.UserDetailsServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

    private UserDetailsServiceImpl userDetailsService;

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
        Class c = new Class();
        c.setId(1);
        System.out.println("---------------" + auth.getPrincipal().toString());
        theModel.addAttribute("students", this.userDetailsService.findByClassId(c));


        return "teachers-page";
    }

    @GetMapping("/students")
    public String showStudentPage() {
        return "students-page";
    }
}
