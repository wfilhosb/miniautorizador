package com.miniautorizador.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique = true)
	private Long numeroCartao;
	private int senhaCartao;
	private double saldoCartao;

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(int senhaCartao) {
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
		return Objects.hash(numeroCartao);
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
		return Objects.equals(numeroCartao, other.numeroCartao);
	}

}
