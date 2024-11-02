package com.project.BlogApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApp.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
