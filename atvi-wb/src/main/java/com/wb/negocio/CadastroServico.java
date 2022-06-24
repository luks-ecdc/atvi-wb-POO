package com.wb.negocio;

import java.util.Collection;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public abstract class CadastroServico extends Cadastro{
	private List<Servico> servicos;
	private Entrada entrada;
	
	public CadastroServico(List<Servico> list) {
		this.servicos = list;
		this.entrada = new Entrada();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void cadastrar2() {
		System.out.println("In�cio do cadastro de servi�os");
		System.out.println("Nome do servi�o: ");
		String nome = entrada.receberTexto();
		System.out.println("Tipo do servi�o (Feminino ou Masculino): ");
		String genero = entrada.receberTexto();
		System.out.println("Valor do servi�o: ");
		double valor = entrada.receberNumeroDouble();
		ListarServicos servicos = new ListarServicos(nome, genero, valor);
		this.servicos.addAll((Collection<? extends Servico>) servicos);
	}
}
