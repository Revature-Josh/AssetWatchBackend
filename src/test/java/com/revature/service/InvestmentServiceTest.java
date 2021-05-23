package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.dao.InvestmentDAO;
import com.revature.dto.InvestmentDTO;
import com.revature.dto.UserDTO;
import com.revature.model.Investment;
import com.revature.model.User;

//testing git with comment change

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvestmentServiceTest {
	
	private static InvestmentDAO mockInvestmentDAO;
	
	private static InvestmentService investmentService;
	
	@BeforeClass
	public static void setUp() {
		mockInvestmentDAO = mock(InvestmentDAO.class);
		
		investmentService = new InvestmentService();
		investmentService.setInvestmentDAO(mockInvestmentDAO);
		
		InvestmentDTO testInvestmentDTO = new InvestmentDTO();
		testInvestmentDTO.setQuantity(10);
		testInvestmentDTO.setTickerSymbol("aapl");
		testInvestmentDTO.setUser(new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com"));
		
		UserDTO testUserDTO = new UserDTO(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com");
		Investment testInvestment = new Investment(testInvestmentDTO);
		
		List<Investment> testInvestmentList = new ArrayList<Investment>();
		testInvestmentList.add(testInvestment);
		
		when(mockInvestmentDAO.addInvestment(eq(testInvestmentDTO))).thenReturn(testInvestment);
		when(mockInvestmentDAO.updateInvestment(eq(testInvestmentDTO))).thenReturn(testInvestment);
		when(mockInvestmentDAO.removeInvestment(eq(testInvestmentDTO))).thenReturn(testInvestment);
		when(mockInvestmentDAO.getInvestmentsByUserId(eq(testUserDTO))).thenReturn(testInvestmentList);
	}
	
	@Test
	@Order(1)
	public void testAddInvestment() {
		InvestmentDTO testInvestmentDTO = new InvestmentDTO();
		testInvestmentDTO.setQuantity(10);
		testInvestmentDTO.setTickerSymbol("aapl");
		testInvestmentDTO.setUser(new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com"));
		Investment expected = new Investment(testInvestmentDTO);
		
		assertEquals(expected,
				investmentService.addInvestment(testInvestmentDTO));
	}
	
	@Test
	@Order(2)
	public void testUpdateInvestment() {
		InvestmentDTO testInvestmentDTO = new InvestmentDTO();
		testInvestmentDTO.setQuantity(10);
		testInvestmentDTO.setTickerSymbol("aapl");
		testInvestmentDTO.setUser(new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com"));
		Investment expected = new Investment(testInvestmentDTO);
		
		assertEquals(expected,
				investmentService.updateInvestment(testInvestmentDTO));
	}
	
	@Test
	@Order(3)
	public void testRemoveInvestment() {
		InvestmentDTO testInvestmentDTO = new InvestmentDTO();
		testInvestmentDTO.setQuantity(10);
		testInvestmentDTO.setTickerSymbol("aapl");
		testInvestmentDTO.setUser(new User(2, "myUser", "Mcgee", "N/A", "l33t", "randomStranger@somedomain.com"));
		Investment expected = new Investment(testInvestmentDTO);
		
		assertEquals(expected,
				investmentService.removeInvestment(testInvestmentDTO));
	}
	
}
