package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.revature.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class User {
	
	public User(UserDTO userDTO) {
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.email = userDTO.getEmail();
	}
	
	
	@Column(name="userID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
}