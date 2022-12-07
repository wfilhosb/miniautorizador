package com.miniautorizador.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoCartao;
	private Long numeroCartao;
	private String senhaCartao;
	private double saldoCartao;

	public Long getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(Long codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public double getSaldoCartao() {
		return saldoCartao;
	}

	public void setSaldoCartao(double saldoCartao) {
		this.saldoCartao = saldoCartao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(codigoCartao, other.codigoCartao);
	}

}
