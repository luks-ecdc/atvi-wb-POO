package com.wb.excluir;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.modelo.Servico;

public class DeleteServico extends Excluir{
	private List<Servico> servicos;
	private Entrada entrada;

	public DeleteServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void excluir() {
		System.out.println("\nInício da exclusão de um serviço");
		System.out.println("--------------------------------");
				
		Lista listarServicos = new Lista(servicos);
		listarServicos.lista();
		
		int numServico = 0;
		while (true) {
			System.out.println("Informe o número do serviço que deseja atualizar:");
			numServico = entrada.receberNumeroInteiro();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("Número de serviço inválido! Verifique suas informações.");
		}
		
		this.servicos.remove(numServico - 1);
		System.out.println("Serviço excluído com sucesso!");
	}
}
