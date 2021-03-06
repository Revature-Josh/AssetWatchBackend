package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.InvestmentDAO;
import com.revature.dao.UserDAO;
import com.revature.dto.InvestmentDTO;
import com.revature.dto.UserDTO;
import com.revature.model.Investment;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Service
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class InvestmentService {

	@Autowired
	InvestmentDAO investmentDAO;
	
	@Transactional(readOnly = true)
	public List<Investment> getInvestmentsByUserId(@Valid UserDTO userDTO) {
		return investmentDAO.getInvestmentsByUserId(userDTO);
	}

	@Transactional
	public Investment addInvestment(@Valid InvestmentDTO investmentDTO) {
		return investmentDAO.addInvestment(investmentDTO);
	}

	@Transactional
	public Investment removeInvestment(@Valid InvestmentDTO investmentDTO) {
		return investmentDAO.removeInvestment(investmentDTO);
	}

	@Transactional
	public Investment updateInvestment(@Valid InvestmentDTO investmentDTO) {
		return investmentDAO.updateInvestment(investmentDTO);
	}

}
