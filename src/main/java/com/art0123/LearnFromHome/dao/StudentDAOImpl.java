package com.art0123.LearnFromHome.dao;

import com.art0123.LearnFromHome.entity.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        // get hibernate session
        Session session = entityManager.unwrap(Session.class);

        // save student
        session.saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        // get session
        Session session = entityManager.unwrap(Session.class);

        // query students and delete with primary key
        Query query = session.createQuery("DELETE FROM Student WHERE id=:theId");

        query.setParameter("theId", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Student findStudentById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Student student = session.get(Student.class, id);

        return student;
    }
}
