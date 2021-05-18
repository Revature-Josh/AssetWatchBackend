package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dto.UserDTO;
import com.revature.model.User;
import com.revature.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
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
	public @ResponseBody ResponseEntity<User> login(@RequestBody @Valid UserDTO userDTO) {
		
		return ResponseEntity.status(200).body(userService.login(userDTO));
	}
	
	//change return type back
	//@RequestMapping(value="/user/register", method = RequestMethod.POST)
	@PostMapping(path="/user/register")
	public @ResponseBody ResponseEntity<Void> registerUser(@RequestBody @Valid UserDTO userDTO) throws Exception{
		return ResponseEntity.status(200).build();
				//ResponseEntity.status(200).body(userService.registerUser(userDTO));
	}
	
}