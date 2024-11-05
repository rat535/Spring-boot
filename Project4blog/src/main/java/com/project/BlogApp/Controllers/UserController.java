package com.project.BlogApp.Controllers;

import java.util.List;
import java.util.Map;

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

import com.project.BlogApp.Service.UserService;
import com.project.BlogApp.payload.UserDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description ="User related data (CRUD)")
public class UserController {
	@Autowired
	private UserService userService;

	// POST - create user

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto created = this.userService.createUser(userDto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	// PUT - update
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updated = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updated);

	}

	// DELETE - delete the required user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(Map.of("message", "userDeletd"), HttpStatus.OK);
	}

	// Get - All user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// GET User by Id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
