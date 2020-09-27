package com.edusite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusite.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
