package com.project.BlogApp.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.project.BlogApp.Entity.Category;
import com.project.BlogApp.Entity.Comments;
import com.project.BlogApp.Entity.User;

public class PostDto {

	private Integer postId;
	private String title;

	private String content;

	private String imageName;

	private Date addDate;

	private CategoryDto category;

	private UserDto user;

	private Set<Comments> comments = new HashSet<>();

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(Integer postId, String title, String content, String imageName, Date addDate, CategoryDto category,
			UserDto user, Set<Comments> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addDate = addDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
