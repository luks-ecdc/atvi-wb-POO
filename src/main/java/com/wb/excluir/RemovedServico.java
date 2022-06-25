package com.wb.excluir;

import java.util.List;

import com.wb.consumo.ListaServUsados;
import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class RemovedServico  extends Excluir{
	private List<Cliente> clientes;
	private Entrada entrada;

	public RemovedServico(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}
	
	@Override
	public void excluir() {
		System.out.println("\nInício da remoção de serviços consumidos por um cliente");
		System.out.println("-------------------------------------------------------");
		
		Lista listagemClientes = new ListaAllClientes(clientes, 0);
		listagemClientes.lista();
		
		while(true) {
			int numCliente = 0;
			while (true) {
				System.out.println("Informe o número do cliente (Digite 0 para sair):");
				numCliente = entrada.receberNumeroInteiro();
				if(numCliente == 0) {
					break;
				}
				if (numCliente > 0 && numCliente <= clientes.size()) {
					if (clientes.get(numCliente-1).getServUsaddos().size() > 0) {
						break;
					} else {
						System.out.println("Este cliente não possui serviços consumidos!");
					}
				} else {
					System.out.println("Número de cliente inválido! Verifique suas informações.");	
				} 	
			}
			if(numCliente == 0) {
				break;
			}
			
			Cliente cliente = clientes.get(numCliente - 1);
			
			ListaServUsados listarServicosConsumidos = new ListaServUsados(cliente, 1);
			List<Servico> servicos = listarServicosConsumidos.listaServUsados();
			
			int numServico = 0; 
			int quantidade = 0;
			while (true) {
				System.out.println("Por favor informe o número do serviço que deseja remover:");
				numServico = entrada.receberNumeroInteiro();
				if (numServico > 0 && numServico <= servicos.size()) {
					break;
				}
				System.out.println("Número de serviço inválido! Verifique se está inserindo o número corretamente.");
			}
			while (true) {
				System.out.println("Por favor informe a quantidade que deseja remover (caso insira um número maior que a quantidae atual, será excluído todos consumido daquele serviço):");
				quantidade = entrada.receberNumeroInteiro();
				if (quantidade > 0) {
					break;
				}
				System.out.println("Números negativos e nulo são inválidos!");
			}
			Servico servico = servicos.get(numServico-1);
			for (int i = 0; i < quantidade; i++) {
				if (!cliente.getServUsaddos().contains(servico)) {
					System.out.println("Número maior do que a quantidade que ele possui! Foram removidos todos!");
					break;
				}
				cliente.getServUsaddos().remove(servico);
			}
			System.out.println("Serviço consumido removido com sucesso!");
			break;
		}
	}
}
