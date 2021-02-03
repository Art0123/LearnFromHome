package com.art0123.LearnFromHome.repository;

import com.art0123.LearnFromHome.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {
    Class findClassByClassName(String className);
}
