package com.wb.listas;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.consumo.ListaProdUsados;
import com.wb.consumo.ListaServUsados;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListaAllClientes extends Lista {
	private List<Cliente> clientes;
	private int tipo;
	
	public ListaAllClientes(List<Cliente> clientes, int tipo) {
		this.clientes = clientes;
		this.tipo = tipo;
	}
	@Override
	public void lista() {
		int l = 1;
		if (tipo == 2) {
			System.out.println("\nLista dos clientes do gênero masculino: ");
		} else {
			if (tipo == 3) {
				System.out.println("\nLista das clientes do gênero feminino: ");
			}
			else {
				System.out.println("\nLista de todos os clientes: ");
			}
		}
		System.out.println("----------------------------------------------");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Cliente cliente : clientes) {
			System.out.println(l + ")");
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			if (tipo != 2 && tipo != 3) {
				System.out.println("Gênero: " + cliente.genero);
			}
			System.out.println("CPF: " + cliente.getCpf().getValor() + " - Data Emissão: " + cliente.getCpf().getDataEmissao().format(formato));
			System.out.println("RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emissão: "  + rg.getDataEmissao().format(formato));
			}
			System.out.println("Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			if (tipo == 0) {
				ListaServUsados listaServUsados = new ListaServUsados(cliente, 0);
				listaServUsados.listaServUsados();
				
				ListaProdUsados listaProdUsadodos = new ListaProdUsados(cliente, 0);
				listaProdUsadodos.listaProdUsados();
			}
			System.out.println("Data de cadastro: " + cliente.getDataCadastro().format(formato));
			System.out.println("----------------------------------------------");
			l++;
		}
	}
}