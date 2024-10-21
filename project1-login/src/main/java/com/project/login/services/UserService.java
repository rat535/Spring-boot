package com.project.login.services;

import com.project.login.Model.User;

public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);
}
