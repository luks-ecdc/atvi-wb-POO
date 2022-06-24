package com.wb.negocio;

import java.util.List;

public class ListarServicos<Servicos> extends Listagem {
	private List<Servicos> servicos;
	
	public ListarServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
	public ListarServicos(String nome, String genero, double valor) {
		
	}
	public List<Servicos> getServicos(){
		return servicos;
	}
	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
	@Override
	public void listar() {
		System.out.println("Lista de todos os serviços:\n");
		for (Servicos servicos : servicos) {
			System.out.println("Nome do serviço: " + servicos + "\n");
			System.out.println("Genero: " + servicos + "\n");
			System.out.println("Valor: " + servicos + "\n");
			System.out.println("--------------------------------------");
		}
	}

}
