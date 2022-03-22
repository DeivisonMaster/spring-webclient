package br.com.preco.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.preco.model.Preco;

@RestController
@RequestMapping("/precos")
public class PrecoController {

	@GetMapping("/{id}")
	public ResponseEntity<Preco> buscarPorId(@PathVariable Long id) throws InterruptedException{
		Preco preco = new Preco(id, new BigDecimal("100"));
		Thread.sleep(3000);
		return ResponseEntity.ok(preco);
	}
}
