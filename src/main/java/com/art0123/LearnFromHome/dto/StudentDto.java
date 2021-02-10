package com.art0123.LearnFromHome.dto;

import com.art0123.LearnFromHome.validation.PasswordMatches;
import com.art0123.LearnFromHome.validation.ValidEmail;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

@PasswordMatches
public class StudentDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String studentName;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String studentEmail;

    public StudentDto() {
    }

    public StudentDto(@NotEmpty String username, @NotEmpty String password, String matchingPassword, @NotEmpty String studentName, @NotEmpty String studentEmail) {
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
