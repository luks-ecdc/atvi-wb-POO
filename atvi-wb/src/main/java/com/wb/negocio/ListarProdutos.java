package com.wb.negocio;

import java.util.List;

public class ListarProdutos<Produtos> extends Listagem {
	private List<Produtos> produtos;
	
	public ListarProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	public ListarProdutos(String nome, double valor) {
		
	}
	public List<Produtos> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:\n");
		for (Produtos produtos : produtos) {
			System.out.println("Nome do produto: " + produtos + "\n");
			System.out.println("Valor: " + produtos + "\n");
			System.out.println("--------------------------------------");
		}
	}
}
