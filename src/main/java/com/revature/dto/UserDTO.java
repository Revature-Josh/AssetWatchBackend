package com.revature.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class UserDTO {

	int id;
	private String firstName;
	private String lastName;

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	private String email;
	
	
	//Constructor for passing credentials
	public UserDTO(String uname, String pword) {
		this.username = uname;
		this.password = pword;
	}
}
