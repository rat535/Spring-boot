package com.project.BlogApp.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApp.Entity.User;
import com.project.BlogApp.Repository.UserRepo;
import com.project.BlogApp.Service.UserService;
import com.project.BlogApp.payload.UserDto;
import com.project.BlogApp.exceptions.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper; 
	
	public User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);//new User(userDto.getId(),userDto.getName(), userDto.getEmail(),userDto.getPassword(),userDto.getAbout());
				//this.modelMapper.map(userDto, User.class);
		return user;
		
	}
	public UserDto UserToDto(User user)
	{
		UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getAbout());
		//this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	 
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user); 
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResoueceNotFound("User", "Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User Updateduser = this.userRepo.save(user);

		return this.UserToDto(Updateduser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResoueceNotFound("User", "Id", userId));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> all= this.userRepo.findAll();
		List<UserDto> userDtos = all.stream().map(user->this.UserToDto(user)).collect(Collectors.toList());
;		return userDtos;
	}

	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(UserId)
				.orElseThrow(()-> new ResoueceNotFound("User", "Id", UserId));
		
		this.userRepo.delete(user);
		
		
	}

}
