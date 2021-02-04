package com.art0123.LearnFromHome.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roleClass;
    @OneToOne
    @JoinColumn(name = "class_id")
    private Class userClass;

    public Student() {
    }

    public Student(String username, String password, String studentName, String email, Role roleClass, Class userClass) {
        this.username = username;
        this.password = password;
        this.studentName = studentName;
        this.email = email;
        this.roleClass = roleClass;
        this.userClass = userClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRoleClass() {
        return roleClass;
    }

    public void setRoleClass(Role roleId) {
        this.roleClass = roleId;
    }

    public Class getUserClass() {
        return userClass;
    }

    public void setUserClass(Class classId) {
        this.userClass = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleClass +
                ", classId=" + userClass +
                '}';
    }
}
