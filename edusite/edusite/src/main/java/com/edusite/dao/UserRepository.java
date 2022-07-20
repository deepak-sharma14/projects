package com.edusite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
