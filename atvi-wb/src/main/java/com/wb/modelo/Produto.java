package com.wb.modelo;

public abstract class Produto {
	public String nome;
	public String valor;
	
	public Produto(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getnome() {
		return nome;
	}

	public String getValor() {
		return valor;
	}
}