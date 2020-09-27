package com.edusite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.ClassTest;

public interface TestRepository extends JpaRepository<ClassTest, Integer> {

}
