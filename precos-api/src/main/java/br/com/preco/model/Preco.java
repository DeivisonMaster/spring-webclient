package br.com.preco.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Preco {
	
	private Long id;
	private BigDecimal preco;
	
	public Preco(Long id, BigDecimal preco) {
		this.id = id;
		this.preco = preco;
	}
	
	
}
