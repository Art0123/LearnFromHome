package com.art0123.LearnFromHome.service;

import com.art0123.LearnFromHome.dao.TeacherDAOImpl;
import com.art0123.LearnFromHome.entity.Student;
import com.art0123.LearnFromHome.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherDAOImpl teacherDAO;

    public void saveTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    public void deleteTeacherById(int id) {
        teacherDAO.deleteTeacherById(id);
    }

    public Teacher getTeacherById(int id) {
        return teacherDAO.findTeacherById(id);
    }
}
