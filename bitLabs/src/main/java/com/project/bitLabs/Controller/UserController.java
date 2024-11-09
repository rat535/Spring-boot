package com.project.bitLabs.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.project.bitLabs.Dto.UserDto;
import com.project.bitLabs.Exception.CustomException;
import com.project.bitLabs.service.FileServices;
import com.project.bitLabs.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profile")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private FileServices fileServices;
	
	@Value("${project.image}")
	private String path;
	
	@Value("${project.resume}")
	private String ps;


	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		
		if (!userService.isValidSpecialization(userDto.getQualification(), userDto.getSpecialization())) {
			throw new CustomException("Invalid specialization for the selected qualification");
        }
		
		
		UserDto created = this.userService.createUser(userDto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> geetById(@PathVariable Long id)
	{
		UserDto userDto = this.userService.getUserById(id);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
		 if (!userService.isValidSpecialization(userDto.getQualification(), userDto.getSpecialization())) {
	            throw new CustomException("Invalid specialization for the selected qualification");
	        }
		 UserDto updatedUser = userService.updateUser(id, userDto);
		 return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	

	@PostMapping("/image/{postId}")
	public ResponseEntity<UserDto> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable Long postId) throws IOException {

		UserDto postDto = this.userService.getUserById(postId);
		String fileName = this.fileServices.uploadImage(path, image);

		postDto.setProfileImage(fileName);
		UserDto updatePost = this.userService.updateUser(postId, postDto);

		return new ResponseEntity<UserDto>(updatePost, HttpStatus.OK);

	}
	
	@PostMapping("/resume/{postId}")
	public ResponseEntity<UserDto> uploadResume(@RequestParam("resume") MultipartFile resume,
			@PathVariable Long postId) throws IOException {

		UserDto postDto = this.userService.getUserById(postId);
		String fileName = this.fileServices.uploadImage(ps, resume);

		System.out.println("Uploaded Resume Filename: " + fileName);

		postDto.setResume(fileName);
		UserDto updatePost = this.userService.updateUser(postId, postDto);

		return new ResponseEntity<UserDto>(updatePost, HttpStatus.OK);

	}

}