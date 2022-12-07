package com.miniautorizador.dto;

import com.miniautorizador.model.Cartao;

public class SaldoDTO {
	
	private double saldo;

	public double getSaldo() {
		return saldo;
	}
	
	public SaldoDTO(Cartao cartao) {
		this.saldo = cartao.getSaldoCartao();
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
