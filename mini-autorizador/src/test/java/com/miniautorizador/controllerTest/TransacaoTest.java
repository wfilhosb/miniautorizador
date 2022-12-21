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
import com.miniautorizador.dto.CartaoDTO;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.model.Mensagem;
import com.miniautorizador.model.Transacoes;
import com.miniautorizador.service.CartaoService;
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

		ResponseEntity<Mensagem> mensagemTransacao = ResponseEntity.status(HttpStatus.CREATED).body(new Mensagem("OK"));

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(transacaoService.realizarTransacao(cartaoTransacao)).thenReturn(mensagemTransacao);

		var result = mockMvc.perform(post("/cartoes").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.conteudoMensagem").contentEquals("OK"));
	}
}
