package com.revature.dto;

import com.revature.model.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class InvestmentDTO {

	private int id;
	
	private String tickerSymbol;
	private int quantity;
	private User user;
}
