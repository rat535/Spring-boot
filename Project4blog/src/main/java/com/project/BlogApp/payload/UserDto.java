package com.project.BlogApp.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min =4,message = "Username must be more than 3 character")
	private String name;
	
    @Email(message ="Email is not valid")
	private String email;
	
    @NotEmpty 
    @Size(min =3, max = 10, message="password must be in between 3 to 10 ")
	private  String password;
	
	private String about;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	

}
