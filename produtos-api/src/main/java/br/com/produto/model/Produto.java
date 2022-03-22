package br.com.produto.model;

import lombok.Data;

@Data
public class Produto {
	private Long id;
	private String nome;
	private String descricao;
	
	public Produto(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}
