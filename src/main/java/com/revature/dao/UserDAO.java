package com.revature.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dto.UserDTO;
import com.revature.exceptions.UserCantLogInExpection;
import com.revature.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public String testUserDAO() {
		return "You've accessed the UserDAO class";
	}
	
	//support function
	public User find(UserDTO userDTO) {
		Session session = sessionFactory.getCurrentSession();		
		return (User)session.createQuery("FROM User u WHERE u.id = ?0").setString(0, Integer.toString(userDTO.getId())).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){
		Session session = sessionFactory.getCurrentSession();		
		return (List<User>)session.createQuery("SELECT u FROM User u").getResultList();
	}

	@Transactional(readOnly = true)
	public User login(UserDTO userDTO) throws UserCantLogInExpection {
		User user=null;
		
		try{Session session = sessionFactory.getCurrentSession();
		
		 user = (User) session.createQuery("FROM User u WHERE u.username = :user AND u.password = :pass")
				.setParameter("user", userDTO.getUsername().trim())
				.setParameter("pass", userDTO.getPassword().trim())
				.getSingleResult();
		
		
		}catch(Exception e) {
			throw new UserCantLogInExpection();
		}
		return user;
	}
	
	@Transactional
	public User registerUser(UserDTO userDTO) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = new User(userDTO);
		session.persist(user);
		return user;
	}
}
