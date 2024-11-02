package com.project.BlogApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.Service.PostService;
import com.project.BlogApp.payload.ApiResponse;
import com.project.BlogApp.payload.PostDto;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer catId)
	{
	PostDto create=	this.postService.createPost(postDto, userId, catId);
		return new ResponseEntity<PostDto>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts= this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> getByCategory(@PathVariable Integer catId)
	{
		List<PostDto> posts= this.postService.getPostByCategory(catId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	//get all post
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPost()
	{
		List<PostDto> allPost=this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	}
	
	//get post by id
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getBYId(@PathVariable Integer postId)
	{
		PostDto allPost=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(allPost,HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		return new ApiResponse("Deletd Successfully", true);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> UpdatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updated =this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updated,HttpStatus.OK);
	}
	
	
}
