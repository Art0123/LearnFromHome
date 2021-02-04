package com.art0123.LearnFromHome.entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher_emails")
public class TeacherEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private int id;
    @Column(name = "email_name")
    private String emailName;
    @Column(name = "password")
    private String password;

    public TeacherEmail() {
    }

    public TeacherEmail(int id, String emailName, String password) {
        this.id = id;
        this.emailName = emailName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TeacherEmail{" +
                "id=" + id +
                ", emailName='" + emailName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
