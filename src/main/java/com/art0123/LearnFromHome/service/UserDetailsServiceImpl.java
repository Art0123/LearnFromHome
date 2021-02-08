package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.entity.*;
import com.art0123.LearnFromHome.repository.StudentRepository;
import com.art0123.LearnFromHome.repository.TeacherRepository;
import com.art0123.LearnFromHome.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByUsername(username);

        if (teacher == null) {
            Student student = studentRepository.findStudentByUsername(username);

            if (student == null) {
                throw new IllegalArgumentException("No user with username: " + username);
            }

            List<GrantedAuthority> authorities = buildStudentAuthority(student);
            return buildStudentForAuthentication(student, authorities);
        }

        List<GrantedAuthority> authorities = buildTeacherAuthority(teacher);
        return buildTeacherForAuthentication(teacher, authorities);
    }

    private User buildTeacherForAuthentication(Teacher teacher,
                                            List<GrantedAuthority> authorities) {
        String username = teacher.getUsername();
        String password = teacher.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        CurrentUser currentUser = new CurrentUser(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        currentUser.setClassName(teacher.getUserClass().getClassName());
        currentUser.setEmail(teacher.getTeacherEmailClass().getEmailName());

        return currentUser;
    }

    private List<GrantedAuthority> buildTeacherAuthority(Teacher teacher) {
        return Arrays.stream(teacher.getRoleClass().getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private User buildStudentForAuthentication(Student student,
                                               List<GrantedAuthority> authorities) {
        String username = student.getUsername();
        String password = student.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        CurrentUser currentUser = new CurrentUser(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        currentUser.setClassName(student.getUserClass().getClassName());
        currentUser.setEmail(student.getStudentEmailClass().getEmailName());

        return currentUser;
    }

    private List<GrantedAuthority> buildStudentAuthority(Student student) {
        return Arrays.stream(student.getRoleClass().getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsByClassName(String className) {
        return studentRepository.findStudentsByUserClass_ClassName(className);
    }

    public Teacher findTeacherByClassName(String className) {
        return teacherRepository.findTeachersByUserClass_ClassName(className);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
