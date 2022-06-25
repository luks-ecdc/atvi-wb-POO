package com.wb.cadastros;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.AllServicos;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class AddServ extends Add{
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private Entrada entrada;

	public AddServ(List<Cliente> clientes, List<Servico> servicos) {
		this.clientes = clientes;
		this.servicos = servicos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("\nInício da adição de serviços consumidos por um cliente");
		System.out.println("------------------------------------------------------");
		
		Lista listagemClientes = new ListaAllClientes(clientes, 2);
		listagemClientes.lista();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor informe o numero do cliente:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("Número de cliente inválido! Verifique suas informações.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		Lista listarServicos = new AllServicos(servicos);
		listarServicos.lista();
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do serviço que deseja adicionar:");
			numServico = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
		}
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
		}
		
		Servico servico = servicos.get(numServico - 1);
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getServUsaddos().add(servico);
		}
		System.out.println("Serviço consumido adicionado com sucesso!");
	}
}
