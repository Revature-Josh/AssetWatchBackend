package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dto.InvestmentDTO;
import com.revature.dto.UserDTO;
import com.revature.model.Investment;
import com.revature.model.User;

import jakarta.validation.Valid;

@Repository
public class InvestmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public String testInvestmentDAO() {
		return "You've accessed the InvestmentDAO class";
	}
	
	public List<User> getAll(){
		Session session = sessionFactory.getCurrentSession();
		return (List<User>)session.createQuery("SELECT i FROM Investment i").getResultList();
	}

	//support function
	public Investment find(InvestmentDTO investmentDTO) {
		Session session = sessionFactory.getCurrentSession();		
		return (Investment)session.createQuery("FROM Investment i WHERE i.id = ?0").setString(0, Integer.toString(investmentDTO.getId())).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public List<Investment> getInvestmentsByUserId(@Valid UserDTO userDTO) {
		Session session = sessionFactory.getCurrentSession();
		return (List<Investment>)session.createQuery("SELECT i FROM Investment i WHERE i.user = ?0").setEntity(0, userDAO.find(userDTO)).list();
	}

	@Transactional
	public Investment addInvestment(@Valid InvestmentDTO investmentDTO) {
		Session session = sessionFactory.getCurrentSession();
		Investment investment = new Investment(investmentDTO);
		session.persist(investment);
		return investment;
	}

	@Transactional
	public Investment removeInvestment(@Valid InvestmentDTO investmentDTO) {
		Session session = sessionFactory.getCurrentSession();
		Investment investment = find(investmentDTO);
		session.remove(investment);
		return investment;

	}

	@Transactional
	public Investment updateInvestment(@Valid InvestmentDTO investmentDTO) {
		Session session = sessionFactory.getCurrentSession();
		Investment investment = find(investmentDTO);
		investment.setQuantity(investmentDTO.getQuantity());
		return investment;
	}

	
}
