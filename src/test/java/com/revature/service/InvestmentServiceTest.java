package com.revature.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;

import com.revature.dao.InvestmentDAO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InvestmentServiceTest {
	
	@Mock
	private static InvestmentDAO mockUserDAO;
	
}
