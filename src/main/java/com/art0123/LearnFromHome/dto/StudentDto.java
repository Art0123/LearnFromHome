package com.art0123.LearnFromHome.dto;

import com.art0123.LearnFromHome.validation.FieldMatch;
import com.art0123.LearnFromHome.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({@FieldMatch(first = "password", second = "matchingPassword", message = "fields must match")})
public class StudentDto {
    @NotNull(message = "is required")
    @Size(min = 1, message ="is required")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 1, message ="is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message ="is required")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message ="is required")
    private String studentName;

    @ValidEmail
    @NotNull(message = "is required")
    @Size(min = 1, message ="is required")
    private String studentEmail;

    private String studentClass;

    public StudentDto() {
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
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
