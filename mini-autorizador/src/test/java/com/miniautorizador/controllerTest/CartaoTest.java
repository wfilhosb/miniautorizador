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
import com.miniautorizador.controller.CartaoController;
import com.miniautorizador.dto.CartaoDTO;
import com.miniautorizador.dto.SaldoDTO;
import com.miniautorizador.model.Cartao;
import com.miniautorizador.service.CartaoService;

@WebMvcTest(CartaoController.class)
public class CartaoTest {

	@MockBean
	private CartaoService cartaoService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void testeCriarNovoCartao_Sucesso() throws Exception {

		Cartao cartaoTransacao = new Cartao();
		cartaoTransacao.setNumeroCartao(9999888899998888L);
		cartaoTransacao.setSenhaCartao(54321);

		ResponseEntity<CartaoDTO> cartaoDTO = ResponseEntity.status(HttpStatus.CREATED).body(null);

		String jsonBody = objectMapper.writeValueAsString(cartaoTransacao);

		when(cartaoService.criarNovo(cartaoTransacao)).thenReturn(cartaoDTO);

		var result = mockMvc.perform(post("/cartoes").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());

	}

	@Test
	public void testeRetornoDeSaldo_doCartao() throws Exception {
		Long numeroCartao = 9999888899998888L;

		ResponseEntity<SaldoDTO> saldoDTO = ResponseEntity.status(HttpStatus.OK).body(new SaldoDTO());

		when(cartaoService.saldoCartao(numeroCartao)).thenReturn(saldoDTO);

		var result = mockMvc.perform(get("/cartoes/{numeroCartao}", numeroCartao).accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.saldo").exists());
	}

	@Test
	public void testeRetornoSemSaldo_doCartao() throws Exception {
		Long numeroCartao = 9999888899998558L;

		ResponseEntity<SaldoDTO> saldoDTO = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		when(cartaoService.saldoCartao(numeroCartao)).thenReturn(saldoDTO);

		var result = mockMvc.perform(get("/cartoes/{numeroCartao}", numeroCartao).accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isNotFound());
		result.andExpect(jsonPath("$.saldo").doesNotHaveJsonPath());
	}
}