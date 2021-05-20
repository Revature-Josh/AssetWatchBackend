package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dto.InvestmentDTO;
import com.revature.dto.UserDTO;
import com.revature.model.Investment;
import com.revature.service.InvestmentService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
@Controller
public class InvestmentController {

	@Autowired
	private InvestmentService investmentService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping(path="/investment/get")
	public @ResponseBody ResponseEntity<List<Investment>> getInvestmentsByUserId(@RequestBody @Valid UserDTO userDTO) throws Exception{
		return ResponseEntity.status(200).body(investmentService.getInvestmentsByUserId(userDTO));
	}
	
	@PostMapping(path="/investment/add")
	public @ResponseBody ResponseEntity<Investment> addInvestment(@RequestBody @Valid InvestmentDTO investmentDTO) throws Exception{
		return ResponseEntity.status(200).body(investmentService.addInvestment(investmentDTO));
	}
	
	@PostMapping(path="/investment/remove")
	public @ResponseBody ResponseEntity<Investment> removeInvestment(@RequestBody @Valid InvestmentDTO investmentDTO) throws Exception{
		return ResponseEntity.status(200).body(investmentService.removeInvestment(investmentDTO));
	}
	
	@PutMapping(path="/investment/update")
	public @ResponseBody ResponseEntity<Investment> updateInvestment(@RequestBody @Valid InvestmentDTO investmentDTO) throws Exception{
		return ResponseEntity.status(200).body(investmentService.updateInvestment(investmentDTO));
	}
}
