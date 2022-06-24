package com.wb.negocio;

import java.util.Collection;
import java.util.List;
import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public abstract class CadastrosProduto extends Cadastro{
	private List<Produto> produtos;
	private Entrada entrada;	
	
	public CadastrosProduto (List<Produto> list) {
		this.produtos = list;
		this.entrada = new Entrada();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void cadastrar1() {
		System.out.println("Início do cadastro de produto");
		System.out.println("Nome do produto: ");
		String nome = entrada.receberTexto();
		System.out.println("Valor do produto: ");
		double valor = entrada.receberNumeroDouble();
		ListarProdutos<Produto> produtos = new ListarProdutos(nome, valor);
		this.produtos.addAll((Collection<? extends Produto>) produtos);
	}
}