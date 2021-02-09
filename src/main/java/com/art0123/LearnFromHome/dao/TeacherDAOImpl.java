package com.art0123.LearnFromHome.dao;

import com.art0123.LearnFromHome.entity.Teacher;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

    private EntityManager entityManager;

    @Autowired
    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(teacher);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Teacher teacher = session.get(Teacher.class, id);
        session.delete(teacher);
    }

    @Override
    @Transactional
    public Teacher findTeacherById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Teacher.class, id);
    }
}
