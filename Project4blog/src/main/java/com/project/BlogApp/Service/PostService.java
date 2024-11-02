package com.project.BlogApp.Service;

import java.util.List;


import com.project.BlogApp.payload.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDto> getAllPost(Integer pageSize, Integer PageNumber);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	
	
}
                                         