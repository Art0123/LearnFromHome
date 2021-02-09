package com.art0123.LearnFromHome.dao;


import com.art0123.LearnFromHome.entity.Teacher;

public interface TeacherDAO {
    void saveTeacher(Teacher teacher);
    void deleteTeacherById(int id);
    Teacher findTeacherById(int id);
}
