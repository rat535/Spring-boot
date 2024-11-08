package com.project.BlogApp.Controllers;

import java.awt.MediaTracker;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.BlogApp.Service.FileService;
import com.project.BlogApp.Service.PostService;
import com.project.BlogApp.payload.ApiResponse;
import com.project.BlogApp.payload.PostDto;
import com.project.BlogApp.payload.PostResponce;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer catId) {
		PostDto create = this.postService.createPost(postDto, userId, catId);
		return new ResponseEntity<PostDto>(create, HttpStatus.CREATED);
	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostByUser(userId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}

	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> getByCategory(@PathVariable Integer catId) {
		List<PostDto> posts = this.postService.getPostByCategory(catId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}

	// get all post
	@GetMapping("/")
	public ResponseEntity<PostResponce> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		PostResponce allPost = this.postService.getAllPost(pageNumber, pageSize);
		return new ResponseEntity<PostResponce>(allPost, HttpStatus.OK);
	}

	// get post by id
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getBYId(@PathVariable Integer postId) {
		PostDto allPost = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(allPost, HttpStatus.OK);
	}

	@DeleteMapping("/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Deletd Successfully", true);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> UpdatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updated = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updated, HttpStatus.OK);
	}

	// IMage Upload

	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException {

		PostDto postDto = this.postService.getPostById(postId);
		String fileName = this.fileService.uploadImage(path, image);

		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

	}
	
	@GetMapping(value = "/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse response) throws IOException{
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
