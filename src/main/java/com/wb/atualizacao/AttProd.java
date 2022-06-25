package com.wb.atualizacao;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.modelo.Produto;

public class AttProd extends Att{
	private List<Produto> produtos;
	private Entrada entrada;

	public AttProd(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("\nIn�cio da atualiza��o de um produto");
		System.out.println("-----------------------------------");
		
		Lista listarProdutos = new Lista(produtos);
		listarProdutos.lista();
		
		int numProduto = 0;
		while (true) {
			System.out.println("Por favor informe o numero do produto que deseja atualizar:");
			numProduto = entrada.receberNumeroInteiro();
			if (numProduto > 0 && numProduto <= produtos.size()) {
				break;
			}
			System.out.println("N�mero de produto inv�lido! Verifique se o n�mero inserido est� correto.");
		}

		Produto produto = produtos.get(numProduto - 1);
		
		boolean execucaoSel = true;
		while(execucaoSel) {
			System.out.println("\nInforma��es do produto:");
			System.out.println("1) Nome: " + produto.nome);
			System.out.println("2) Valor: " + produto.valor);
			System.out.println("0) Sair");
	
			System.out.println("Por favor informe o numero do dado que voc� deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
			case 1:
				System.out.println("Por favor informe o novo valor do nome (Atual: " + produto.nome + "):");
				String nome = entrada.receberTexto();
				produto.nome = nome;
				System.out.println("Nome do produto atualizado com sucesso!");
				break;
			case 2:
				System.out.println("Por favor informe o novo valor (Atual: " + produto.valor + "):");
				double valor = entrada.receberNumeroDouble();
				produto.valor = valor;
				System.out.println("Valor do produto atualizado com sucesso!");
				break;
			default:
				System.out.println("Opera��o n�o entendida.");
			}
		}
	}
}
