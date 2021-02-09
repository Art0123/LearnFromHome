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
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "role_id")
    private Role roleClass;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private Class userClass;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private StudentEmail studentEmailClass;

    public Student() {
    }

    public Student(String username, String password, String studentName, Role roleClass, Class userClass, StudentEmail studentEmailClass) {
        this.username = username;
        this.password = password;
        this.studentName = studentName;
        this.roleClass = roleClass;
        this.userClass = userClass;
        this.studentEmailClass = studentEmailClass;
    }

    public int getId() {
        return id;
    }

    public StudentEmail getStudentEmailClass() {
        return studentEmailClass;
    }

    public void setStudentEmailClass(StudentEmail studentEmailClass) {
        this.studentEmailClass = studentEmailClass;
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
                ", roleClass=" + roleClass +
                ", userClass=" + userClass +
                ", studentEmailClass=" + studentEmailClass +
                '}';
    }
}
