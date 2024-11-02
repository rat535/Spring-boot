package com.project.BlogApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApp.Entity.Category;
import com.project.BlogApp.Entity.Post;
import com.project.BlogApp.Entity.User;

import java.util.List;



public interface PostRepo extends JpaRepository<Post, Integer>{
 
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
