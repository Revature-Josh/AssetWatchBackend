package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UserDAO;
import com.revature.dto.UserDTO;
import com.revature.exceptions.UserCantLogInExpection;
import com.revature.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	//to add a new feature, all that's necessary is to define a function with @Transactional
	// note: if the feature does not affect the database, like this one, you should also set the readOnly property to true
	@Transactional(readOnly = true)
	public User login(UserDTO userDTO) throws UserCantLogInExpection {
		User user=null;
		try{
		user=userDAO.login(userDTO);
		}catch(Exception e)
		{
			throw new  UserCantLogInExpection();
		}
		return user;
		
	}
	
	@Transactional
	public User registerUser(UserDTO userDTO) throws Exception {
		User user;
		if(userDTO == null) {
			throw new  UserCantLogInExpection("This is a userDTO is null exception Thrown from UserService");
		} else {
			user = userDAO.registerUser(userDTO);
		}
		
		return user;
	}
	
	
}
