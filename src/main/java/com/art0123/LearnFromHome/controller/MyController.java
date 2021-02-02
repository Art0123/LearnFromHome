package com.art0123.LearnFromHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/teachers")
    public String showTeacherPage() {
        return "teachers-page";
    }
}
