package com.wb.listas;

import java.util.List;

import com.wb.modelo.Produto;

public abstract class AllProdutos extends Lista{
	private List<Produto> produtos;

	public AllProdutos(List<Produto> produtos) {
		this.produtos= produtos;
	}

	public void listar() {
		int n = 1;
		System.out.println("\nLista de todos os produtos:");
		System.out.println("---------------------------");
		for (Produto produto : produtos) {
			System.out.println(n + ")");
			System.out.println("Nome: " + produto.nome);
			System.out.println("Valor: " + produto.valor);
			System.out.println("---------------------------");
			n++;
		}
	}
}
