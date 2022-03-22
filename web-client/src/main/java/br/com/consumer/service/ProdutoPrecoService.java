package br.com.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.consumer.model.ProdutoPreco;
import reactor.core.publisher.Mono;

@Service
public class ProdutoPrecoService {
	
	@Autowired
	private WebClient webClientProduto;
	
	@Autowired
	private WebClient webClientPreco;
	
	public ProdutoPreco buscarProdutoPorId(Long id){
		Mono<ProdutoPreco> monoProduto = consultaProdutoWS(id);
		Mono<ProdutoPreco> monoPreco = consultaPrecoProdutoWS(id);
		ProdutoPreco produtoComPreco = associaPrecoAoProdutoEmDadosAssincronos(monoProduto, monoPreco);
		return produtoComPreco;
	}

	private ProdutoPreco associaPrecoAoProdutoEmDadosAssincronos(Mono<ProdutoPreco> monoProduto,
			Mono<ProdutoPreco> monoPreco) {
		ProdutoPreco produtoComPreco = Mono.zip(monoProduto, monoPreco).map(tuple -> {
			tuple.getT1().setPreco(tuple.getT2().getPreco());
			return tuple.getT1();
		}).block();
		return produtoComPreco;
	}

	private Mono<ProdutoPreco> consultaPrecoProdutoWS(Long id) {
		Mono<ProdutoPreco> monoPreco = this.webClientPreco
			.method(HttpMethod.GET)
			.uri("/precos/{id}", id)
			.retrieve()
			.bodyToMono(ProdutoPreco.class);
		return monoPreco;
	}

	private Mono<ProdutoPreco> consultaProdutoWS(Long id) {
		Mono<ProdutoPreco> monoProduto = this.webClientProduto
			.method(HttpMethod.GET)
			.uri("/produtos/{id}", id)
			.retrieve()
			.bodyToMono(ProdutoPreco.class);
		return monoProduto;
	}
}
