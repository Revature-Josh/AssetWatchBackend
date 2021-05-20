package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dto.MessageDTO;
import com.revature.dto.UserDTO;
import com.revature.exceptions.UserCantLogInExpection;
import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins="*")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping(value = "/user/test")
	public @ResponseBody String userTestPrint() {
		return "Hello from UserController's Test print";
	}
	
	@RequestMapping(value="/user/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> login(@RequestBody @Valid UserDTO userDTO) throws UserNotFoundException {
		//HttpSession session = request.getSession();
		User user=null;
		try {
			user= userService.login(userDTO);
		}catch(Exception e)
		{
			throw new UserNotFoundException();
		}
	
		if(user!=null)
		{
			  HttpSession session = request.getSession();
			  session.setAttribute("loggedInUser",user);

		}
		return ResponseEntity.status(200).body(user);
		
	}
	
	//change return type back
	//@RequestMapping(value="/user/register", method = RequestMethod.POST)
	@PostMapping(path="/user/register")
	public @ResponseBody ResponseEntity<Object> registerUser(@RequestBody @Valid UserDTO userDTO) throws UserCantLogInExpection{
		
		User user=null;
		try {
			user= userService.registerUser(userDTO);
		} catch (Exception e) {
			throw new UserCantLogInExpection();
		}
		 return ResponseEntity.status(200).body((user));
	}
	
	@RequestMapping(path="user/current", method= RequestMethod.POST) 
    public ResponseEntity<User> getCurrentUser() throws UserNotFoundException{
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("loggedInUser") == null) {
            throw new UserNotFoundException();
        }

        User user = (User) session.getAttribute("loggedInUser");
        return ResponseEntity.status(200).body(user);
       
    }

	
	@RequestMapping(path="user/logout", method= RequestMethod.GET) 
    public ResponseEntity<MessageDTO> LogoutUser(){
        HttpSession session = request.getSession();
        MessageDTO message=null;
        if (session == null || session.getAttribute("loggedInUser") == null) {
        	message= new MessageDTO("No user was already log in with a session");
        	
        }
        message= new MessageDTO("Logout out current user");
        session.invalidate();
       return ResponseEntity.status(200).body(message);
       
    }
	
}