package com.project.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.login.Model.User;



public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
