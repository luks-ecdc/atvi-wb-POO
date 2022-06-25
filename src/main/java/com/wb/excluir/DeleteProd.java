package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.AllProdutos;
import com.wb.listas.Lista;
import com.wb.modelo.Produto;

public class DeleteProd extends Excluir{
	private List<Produto> produtos;
	private Entrada entrada;

	public DeleteProd(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nIn�cio da exclus�o de um produto");
		System.out.println("--------------------------------");
				
		Lista listarProdutos = new AllProdutos(produtos);
		listarProdutos.lista();
		
		int numProduto = 0;
		while (true) {
			System.out.println("Informe o numero do produto que deseja atualizar:");
			numProduto = entrada.receberNumeroInteiro();
			if (numProduto > 0 && numProduto <= produtos.size()) {
				break;
			}
			System.out.println("N�mero de produto inv�lido! Verifique suas informa��es.");
		}
		
		this.produtos.remove(numProduto - 1);
		System.out.println("Produto exclu�do com sucesso!");
	}
}
