package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UserDAO;
import com.revature.dto.UserDTO;
import com.revature.exceptions.UserCantLogInExpection;
import com.revature.model.User;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

	// Fake repository dependency (mocked w/ Mockito)
	private static UserDAO mockUserDAO;
	
	private static UserService userService;
	
	@BeforeClass
	public static void setUp() throws Exception {
		mockUserDAO = mock(UserDAO.class);
		
		userService = new UserService();
		userService.setUserDAO(mockUserDAO);
		
		UserDTO testUserDTO = new UserDTO(0, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com");
		User expectedAfterRegister = new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com");
		
		//when statements for tests		
		when(userService.userDAO.registerUser(eq(testUserDTO))).thenReturn(expectedAfterRegister);
		when(userService.userDAO.login(eq(testUserDTO))).thenReturn(expectedAfterRegister);
	}
	
	@Test
	@Order(1)
	public void registerUserTest() throws Exception {
		UserDTO registerInput = new UserDTO(0, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com");
		User user = new User(registerInput);
		user.setId(2);
		assertEquals(user,
				userService.registerUser(registerInput));
	}
				
	
	
	@Test
	@Order(2)
	public void userLoginTest() throws UserCantLogInExpection{
		User expectedForlogin = new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com");
		
		assertEquals( expectedForlogin,
				userService.login(new UserDTO(0, "myUser", "Mcgee", "N/A",
				"l33t", "randomStranger@somedomain.com"))
				);
	}
	
}