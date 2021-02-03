package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.entity.Teacher;
import com.art0123.LearnFromHome.repository.StudentRepository;
import com.art0123.LearnFromHome.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Teacher> teacher = teacherRepository.findTeacherByUsername(username);

        if (teacher.isEmpty()) {
            Optional<Student> student = studentRepository.findStudentByUsername(username);

            if (student.isEmpty()) {
                throw new NoSuchElementException("User '" + username + "' doesn't exist");
            }

            return student.map(MyUserDetails::new).get();
        }
        return teacher.map(MyUserDetails::new).get();
    }
}
