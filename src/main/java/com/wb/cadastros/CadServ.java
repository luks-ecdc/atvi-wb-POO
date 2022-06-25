package com.wb.cadastros;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadServ extends Add{
	private List<Servico> servicos;
	private Entrada entrada;

	public CadServ(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nIn�cio do cadastro do servi�o");
		System.out.println("-----------------------------");
		
		System.out.println("Por favor informe o nome do servi�o:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do servi�o:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		Servico servico = new Servico(nome, valor);
		this.servicos.add(servico);
		System.out.println("Servi�o cadastrado com sucesso!");

	}
}
