package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.revature.dto.InvestmentDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class Investment {
	
	public Investment(@Valid InvestmentDTO investmentDTO) {
		this.id = investmentDTO.getId();
		this.tickerSymbol = investmentDTO.getTickerSymbol();
		this.quantity = investmentDTO.getQuantity();
		this.user = investmentDTO.getUser();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tickerSymbol;
	private double quantity;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
}
