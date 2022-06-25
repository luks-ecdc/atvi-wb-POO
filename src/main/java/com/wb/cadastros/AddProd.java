package com.wb.cadastros;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class AddProd extends Add{
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private Entrada entrada;

	public AddProd(List<Cliente> clientes, List<Produto> produtos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("\nInício da adição de produtos consumidos por um cliente");
		System.out.println("------------------------------------------------------");
		
		ListaAllClientes listagemClientes = new ListaAllClientes(clientes, 2);
		listagemClientes.lista();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		Lista listarProdutos = new Lista(produtos);
		listarProdutos.lista();
		
		int numProduto = 0;
		while (true) {
			System.out.println("Por favor informe o numero do produto que deseja atualizar:");
			numProduto = entrada.receberNumeroInteiro();
			if (numProduto > 0 && numProduto <= produtos.size()) {
				break;
			}
			System.out.println("Número de produto inválido! Verifique suas informações.");
		}
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique suas informações.");
		}
		
		Produto produto = produtos.get(numProduto - 1);
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getProdUsados().add(produto);
		}
		System.out.println("Produto consumido adicionado com sucesso!");
	}
}
