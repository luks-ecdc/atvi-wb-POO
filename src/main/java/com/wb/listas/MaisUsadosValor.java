package com.wb.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantClientes;
import com.wb.modelo.Servico;

public class MaisUsadosValor {
	private Empresa empresa;
	private Entrada entrada;

	public MaisUsadosValor(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	public void listar() {
		int usadoNum = 0;
		boolean execucaoUsado = true;
		while(execucaoUsado) {
			System.out.println("Deseja mostrar os 5 clientes que mais consumiram, em valor:");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			usadoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (usadoNum == 1 || usadoNum == 2) {
				execucaoUsado = false;
			}
			else {
				System.out.println("Valor inválido! Verifique suas informações.");
			}
		}
		
		String consumido = "";
		List <QuantClientes> quantidadeTodosClientes = new ArrayList<QuantClientes>();
		for (Cliente cliente : empresa.getClientes()) {
			if (usadoNum == 1) {
				consumido = "serviços";
				double valorServicos = 0;
				for (Servico servico : cliente.getServUsaddos()) {
					valorServicos += servico.valor;
				}	
				QuantClientes quantidadeCliente = new QuantClientes(cliente, valorServicos);
				quantidadeTodosClientes.add(quantidadeCliente);
			} else {
				consumido = "produtos";
				double valorProdutos = 0;
				for (Produto produto : cliente.getProdUsados()) {
					valorProdutos += produto.valor;
				}	
				QuantClientes quantidadeCliente = new QuantClientes(cliente, valorProdutos);
				quantidadeTodosClientes.add(quantidadeCliente);
			}
		}
			
		Collections.sort(quantidadeTodosClientes, new Comparator<QuantClientes>() {
			  public int compare(QuantClientes qc1, QuantClientes qc2) {
			    return qc2.getValorGasto().compareTo(qc1.getValorGasto());
			  }
			});
		
		int cont = 1;
		System.out.println("\nLista dos 5 clientes que mais gastaram em " + consumido);
		System.out.println("-------------------------------------------------");
		for (QuantClientes quantidadeCliente : quantidadeTodosClientes) {
			if (cont > 5) {
				break;
			}
			System.out.println(cont + ")");
			System.out.println("Nome: " + quantidadeCliente.cliente.nome);
			System.out.println("CPF: " + quantidadeCliente.cliente.getCpf().getValor());
			System.out.println("Valor total de " + consumido +  " consumidos: " + quantidadeCliente.getValorGasto());
			System.out.println("-------------------------------------------------");
			cont++;			
		}	
	}
}
