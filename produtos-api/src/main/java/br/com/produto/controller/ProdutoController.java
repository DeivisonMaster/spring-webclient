package br.com.produto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) throws InterruptedException{
		Produto produto = new Produto(id, "Ventilador", "Venta Muito");
		Thread.sleep(3000);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
}
