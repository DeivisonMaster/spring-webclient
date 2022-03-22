package br.com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebclientApplication {
	private static final String BASE_URL_PRODUTO = "http://localhost:8081";
	private static final String BASE_URL_PRECO = "http://localhost:8082";

	@Bean
	public WebClient webClientProduto(WebClient.Builder builder){
		return builder
			.baseUrl(BASE_URL_PRODUTO)
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build(); 
	}
	
	@Bean
	public WebClient webClientPreco(WebClient.Builder builder){
		return builder
				.baseUrl(BASE_URL_PRECO)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build(); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebclientApplication.class, args);
	}

}
