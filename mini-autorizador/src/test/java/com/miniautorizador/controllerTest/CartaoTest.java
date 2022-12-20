package com.miniautorizador.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.awt.PageAttributes.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.*;

import com.miniautorizador.model.Cartao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.miniautorizador.controller.*;
import com.miniautorizador.dto.CartaoDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CartaoController.class)
public class CartaoTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartaoController cartaoController;

	@Test
	public void criarNovoCartao() throws Exception {

	}
}