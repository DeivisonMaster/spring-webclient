package br.com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.consumer.model.ProdutoPreco;
import br.com.consumer.service.ProdutoPrecoService;

@RestController
public class ProdutoPrecoController {	
	
	@Autowired
	private ProdutoPrecoService service;
	
	@GetMapping("/produto/{id}/preco")
	public ResponseEntity<ProdutoPreco> buscarProdutoComPrecoPorIdProduto(@PathVariable Long id){
		ProdutoPreco produtoComPreco = this.service.buscarProdutoPorId(id);
		return ResponseEntity.ok(produtoComPreco);
	}
	
}
