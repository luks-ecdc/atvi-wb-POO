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
		System.out.println("\nIn�cio da adi��o de servi�os consumidos por um cliente");
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
			System.out.println("N�mero de cliente inv�lido! Verifique suas informa��es.");
		}
		
		Cliente cliente = clientes.get(numCliente - 1);
		
		Lista listarServicos = new AllServicos(servicos);
		listarServicos.lista();
		
		int numServico = 0;
		while (true) {
			System.out.println("Por favor informe o numero do servi�o que deseja adicionar:");
			numServico = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		int numQuantidade = 0;
		while (true) {
			System.out.println("Por favor informe a quantidade que deseja adicionar:");
			numQuantidade = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (numQuantidade > 0) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
		}
		
		Servico servico = servicos.get(numServico - 1);
		for (int i = 1; i <= numQuantidade; i++) {
			cliente.getServUsaddos().add(servico);
		}
		System.out.println("Servi�o consumido adicionado com sucesso!");
	}
}
