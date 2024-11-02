package com.project.BlogApp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApp.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
