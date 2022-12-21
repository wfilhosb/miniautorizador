package com.miniautorizador.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniautorizador.controller.TransacoesController;
import com.miniautorizador.model.Mensagem;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.service.TransacaoService;

@WebMvcTest(TransacoesController.class)
public class TransacaoTest {
	
	@MockBean
	private TransacaoService transacaoService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
	}
	
	@Test
	public void testeTransacao_Sucesso() throws Exception {

		Transacoes cartaoTransacao = new Transacoes();
		cartaoTransacao.setNumeroCartaoTransacao(9999888899998888L);
		cartaoTransacao.setSenhaCartaoTransacao(54321);
		cartaoTransacao.setValorTransacao(500);

		ResponseEntity<Mensagem> statusTransacao = ResponseEntity.status(HttpStatus.CREATED).body(new Mensagem("OK"));

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(transacaoService.realizarTransacao(cartaoTransacao)).thenReturn(statusTransacao);

		var result = mockMvc.perform(post("/transacoes/").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.conteudoMensagem").value("OK"));
	}
	
	@Test
	public void testeSaldoInsuficiente_Falha() throws Exception {

		Transacoes cartaoTransacao = new Transacoes();
		cartaoTransacao.setNumeroCartaoTransacao(9999888899998888L);
		cartaoTransacao.setSenhaCartaoTransacao(54321);
		cartaoTransacao.setValorTransacao(900);

		ResponseEntity<Mensagem> statusTransacao = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Mensagem("SALDO_INSUFICIENTE"));

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(transacaoService.realizarTransacao(cartaoTransacao)).thenReturn(statusTransacao);

		var result = mockMvc.perform(post("/transacoes/").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnprocessableEntity());
		result.andExpect(jsonPath("$.conteudoMensagem").value("SALDO_INSUFICIENTE"));
	}
	
	@Test
	public void testeSenhaIncorreta_Falha() throws Exception {

		Transacoes cartaoTransacao = new Transacoes();
		cartaoTransacao.setNumeroCartaoTransacao(9999888899998888L);
		cartaoTransacao.setSenhaCartaoTransacao(57777);
		cartaoTransacao.setValorTransacao(500);

		ResponseEntity<Mensagem> statusTransacao = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Mensagem("SENHA_INCORRETA"));

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(transacaoService.realizarTransacao(cartaoTransacao)).thenReturn(statusTransacao);

		var result = mockMvc.perform(post("/transacoes/").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnprocessableEntity());
		result.andExpect(jsonPath("$.conteudoMensagem").value("SENHA_INCORRETA"));
	}
	
	@Test
	public void testeCartaoInexistente_Falha() throws Exception {

		Transacoes cartaoTransacao = new Transacoes();
		cartaoTransacao.setNumeroCartaoTransacao(999999999999L);
		cartaoTransacao.setSenhaCartaoTransacao(54321);
		cartaoTransacao.setValorTransacao(500);

		ResponseEntity<Mensagem> statusTransacao = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Mensagem("CARTAO_INEXISTENTE"));

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(transacaoService.realizarTransacao(cartaoTransacao)).thenReturn(statusTransacao);

		var result = mockMvc.perform(post("/transacoes/").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnprocessableEntity());
		result.andExpect(jsonPath("$.conteudoMensagem").value("CARTAO_INEXISTENTE"));
	}
}
