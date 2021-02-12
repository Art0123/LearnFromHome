package com.art0123.LearnFromHome.controller;

import com.art0123.LearnFromHome.dto.StudentDto;
import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.repository.StudentRepository;
import com.art0123.LearnFromHome.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/new")
public class RegistrationController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/registration")
    public String showRegistrationForm(Model theModel) {
        StudentDto studentDto = new StudentDto();
        theModel.addAttribute("student", studentDto);

        return "registration-form";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@Validated @ModelAttribute("student") StudentDto studentDto,
                                      BindingResult bindingResult,
                                      Model theModel) {

        String username = studentDto.getUsername();
        logger.info("Trying to process registration for student: " + username);

        if (bindingResult.hasErrors()) {
            logger.info("result had errors");
            return "registration-form";
        }

        Student existing = studentRepository.findStudentByUsername(username);

        if (existing != null) {
            theModel.addAttribute("student", new StudentDto());
            theModel.addAttribute("registrationError", "Student already exists");
            logger.info("Student already exists with username: " + username);

            return "registration-form";
        }

        studentService.saveRegisteredStudent(studentDto);
        logger.info("Created Student: " + username + " for class: " + studentDto.getStudentClass());

        return "confirmation-page";
    }
}
