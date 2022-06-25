package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Cliente;

public class DeleteCliente extends Excluir{
	private List<Cliente> clientes;
	private Entrada entrada;

	public DeleteCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nInício da exclusão de um cliente");
		System.out.println("--------------------------------");
				
		Lista listagemClientes = new ListaAllClientes(clientes, 1);
		listagemClientes.lista();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Informe o número do cliente que deseja excluir:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("Número de cliente inválido! Verifique suas informações.");
		}
		
		this.clientes.remove(numCliente - 1);
		System.out.println("Cliente excluído com sucesso!");
	}
}
