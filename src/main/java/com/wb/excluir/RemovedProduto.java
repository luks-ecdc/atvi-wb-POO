package com.wb.excluir;

import java.util.List;

import com.wb.consumo.ListaProdUsados;
import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class RemovedProduto extends Excluir{
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemovedProduto(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void excluir() {
		System.out.println("\nInício da remoção de produtos consumidos por um cliente");
		System.out.println("-------------------------------------------------------");
		
		Lista listagemClientes = new ListaAllClientes(clientes, 0);
		listagemClientes.lista();
		
		while(true) {
			int numCliente = 0;
			while (true) {
				System.out.println("Por favor informe o numero do cliente (Digite 0 para sair):");
				numCliente = entrada.receberNumeroInteiro();
				if(numCliente == 0) {
					break;
				}
				if (numCliente > 0 && numCliente <= clientes.size()) {
					if (clientes.get(numCliente-1).getProdUsados().size() > 0) {
						break;
					} else {
						System.out.println("Este cliente não possui produtos consumidos!");
					}
				} else {
					System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");	
				} 	
			}
			if(numCliente == 0) {
				break;
			}
			
			Cliente cliente = clientes.get(numCliente - 1);
			
			ListaProdUsados listarProdutosConsumidos = new ListaProdUsados(cliente, 1);
			List<Produto> produtos = listarProdutosConsumidos.listaProdUsados();
			
			int numProduto = 0; 
			int quantidade = 0;
			while (true) {
				System.out.println("Informe o número do produto que deseja remover:");
				numProduto = entrada.receberNumeroInteiro();
				if (numProduto > 0 && numProduto <= produtos.size()) {
					break;
				}
				System.out.println("Número de produto inválido! Verifique suas informações.");
			}
			while (true) {
				System.out.println("Por favor informe a quantidade que deseja remover (caso número maior que a quantidae atual, será excluído todos os produto):");
				quantidade = entrada.receberNumeroInteiro();
				if (quantidade > 0) {
					break;
				}
				System.out.println("Números negativos/nulo são inválidos!");
			}
			Produto produto = produtos.get(numProduto - 1);
			for (int i = 0; i < quantidade; i++) {
				if (!cliente.getProdUsados().contains(produto)) {
					System.out.println("Foram removidos todos!");
					break;
				}
				cliente.getProdUsados().remove(produto);
			}
			System.out.println("Produto consumido removido com sucesso!");
			break;
		}
	}
}
