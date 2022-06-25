package com.wb.modelo;

public abstract class Servico {
	public String nome;
	public double valor;
	
	public Servico(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
}