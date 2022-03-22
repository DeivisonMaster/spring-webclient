package br.com.consumer.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoPreco {
	
	private Long codigo;
	private String nome;
	private BigDecimal preco;
	
	public ProdutoPreco() {
	}
	
	public ProdutoPreco(Long codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
}
