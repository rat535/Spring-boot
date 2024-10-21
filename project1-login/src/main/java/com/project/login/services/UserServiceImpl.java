package com.project.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.login.Model.User;
import com.project.login.repository.UserRepo;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepository;

	public boolean registerUser(User user )
	{
		try {
		userRepository.save(user);
		return true;
		}
		catch(Exception e) {
		    e.printStackTrace();
			return false;
		}
	}
	public User loginUser(String email,String password)
	{
		User Validuser = userRepository.findByEmail(email);
		
		if(Validuser != null && Validuser .getPassword().equals(password))
		{
			return Validuser;
		}
		return null;
	}
}
