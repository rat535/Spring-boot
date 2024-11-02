package com.project.BlogApp.Service.impl;



import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.BlogApp.Entity.Category;
import com.project.BlogApp.Entity.Post;
import com.project.BlogApp.Entity.User;
import com.project.BlogApp.Repository.CategoryRepo;
import com.project.BlogApp.Repository.PostRepo;
import com.project.BlogApp.Repository.UserRepo;
import com.project.BlogApp.Service.PostService;
import com.project.BlogApp.exceptions.ResoueceNotFound;
import com.project.BlogApp.payload.PostDto;

import org.springframework.data.domain.*;

@Service
public class POstServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private  UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo; 

	
	
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResoueceNotFound("User", "User Id", userId));
		
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResoueceNotFound("Category", "id", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setCategory(cat);
		post.setUser(user);
		Post newPost = this.postRepo.save(post);
		  
		return this.modelMapper.map(newPost, PostDto.class);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResoueceNotFound("post", "id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(post); 
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResoueceNotFound("Post", "id", postId));
		this.postRepo.delete(post);
		
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		//List<Post> allPosts = this.postRepo.findAll();
		
		int pageSize =5;
		int pageNumber = 1;
		Pageable p = PageRequest.of(pageNumber,pageSize);
		
		Page<Post> pagePost = this.postRepo.findAll(p);
		List<Post> allPosts = pagePost.getContent();
		
		List<PostDto> posts = allPosts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return posts;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResoueceNotFound("post", "id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResoueceNotFound("Category", "id", categoryId));
        List<Post> posts =  this.postRepo.findByCategory(cat);
        
        List<PostDto> postDtos= posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResoueceNotFound("User", "User Id", userId));
		List<Post> up=this.postRepo.findByUser(user);
		
		List<PostDto> udp= up.stream().map((ups)->this.modelMapper.map(ups, PostDto.class)).collect(Collectors.toList());
		
		return udp;
	}

}
