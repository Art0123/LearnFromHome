package com.art0123.LearnFromHome.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
    @OneToOne
    @JoinColumn(name = "class_id")
    private Class classId;

    public Teacher() {
    }

    public Teacher(String username, String password, String teacherName, String email, Role roleId, Class classId) {
        this.username = username;
        this.password = password;
        this.teacherName = teacherName;
        this.email = email;
        this.roleId = roleId;
        this.classId = classId;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", classId=" + classId +
                '}';
    }
}
