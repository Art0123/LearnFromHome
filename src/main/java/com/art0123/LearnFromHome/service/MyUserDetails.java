package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.entity.Teacher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;

    public MyUserDetails(Teacher teacher) {
        this.username = teacher.getUsername();
        this.password = teacher.getPassword();
        this.roles = Arrays.stream(teacher.getRoleId().getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    public MyUserDetails(Student student) {
        this.username = student.getUsername();
        this.password = student.getPassword();
        this.roles = Arrays.stream(student.getRoleId().getRoleName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    public MyUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
