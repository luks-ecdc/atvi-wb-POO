package com.wb.listas;

import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ListClienteGenero extends Lista{
	private List<Cliente> clientes;
	private Entrada entrada;
	
	public ListClienteGenero(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void lista() {
		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Qual gênero vai ser listado?");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
					System.out.println("Valor inválido, tente novamente.");
				}
			}
		}
		List<Cliente> clientesGenero = new ArrayList<Cliente>();
		for (Cliente cliente : clientes) {
			if (cliente.genero.equals(genero)) {
				clientesGenero.add(cliente);
			}
		}
		if (clientesGenero.size() == 0) {
			System.out.println("Não há clientes do gênero " + genero.toLowerCase() + " cadastrados!");
		} else {
			if (genero.equals("Masculino")){
				Lista listagemClientes = new ListaAllClientes(clientesGenero, 2);
				listagemClientes.lista();	
			} else {
				Lista listagemClientes = new ListaAllClientes(clientesGenero, 3);
				listagemClientes.lista();	
			}
		}
	}
}
