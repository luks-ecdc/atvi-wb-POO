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
		System.out.println("\nIn�cio da exclus�o de um servi�o");
		System.out.println("--------------------------------");
				
		Lista listarServicos = new Lista(servicos);
		listarServicos.lista();
		
		int numServico = 0;
		while (true) {
			System.out.println("Informe o n�mero do servi�o que deseja atualizar:");
			numServico = entrada.receberNumeroInteiro();
			if (numServico > 0 && numServico <= servicos.size()) {
				break;
			}
			System.out.println("N�mero de servi�o inv�lido! Verifique suas informa��es.");
		}
		
		this.servicos.remove(numServico - 1);
		System.out.println("Servi�o exclu�do com sucesso!");
	}
}
