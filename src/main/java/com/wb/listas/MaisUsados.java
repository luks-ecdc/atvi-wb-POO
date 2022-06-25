package com.wb.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantProdutos;
import com.wb.modelo.QuantServico;
import com.wb.modelo.Servico;

public class MaisUsados {
	private Empresa empresa;
	private Entrada entrada;

	public MaisUsados(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	public void lista() {
		int usadoNum = 0;
		boolean execucaoUsados = true;
		while(execucaoUsados) {
			System.out.println("Deseja mostrar qual mais consumidos?");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			usadoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (usadoNum == 1 || usadoNum == 2) {
				execucaoUsados = false;
			}
			else {
				System.out.println("Valor inválido. Verifique suas informações.");
			}
		}

		if (usadoNum == 1) {
			List <QuantServico> quantidadeTodosServicos = new ArrayList<QuantServico>();
			for (Servico servico : empresa.getServicos()) {
				int quantidade = 0;
				for (Cliente cliente : empresa.getClientes()) {
					for (Servico servicoCliente : cliente.getServUsaddos()) {
						if(servico.equals(servicoCliente)) {
							quantidade++;
						}
					}
				}
				QuantServico quantidadeServico = new QuantServico(servico, quantidade);
				quantidadeTodosServicos.add(quantidadeServico);
			}
			
			Collections.sort(quantidadeTodosServicos, new Comparator<QuantServico>() {
				  public int compare(QuantServico qs1, QuantServico qs2) {
				    return qs2.getQuantUsados().compareTo(qs1.getQuantUsados());
				  }
				});
			
			if (quantidadeTodosServicos.size() == 0) {
				System.out.println("Não há serviços cadastrados!");
			} else {
				System.out.println("Lista dos serviços mais consumidos");
				System.out.println("--------------------------------------");
				for (QuantServico quantidadeServico : quantidadeTodosServicos) {
					System.out.println("Nome: " + quantidadeServico.servico.nome);
					System.out.println("Quantidade de vezes consumido: " + quantidadeServico.getQuantUsados());
					System.out.println("--------------------------------------");
				}
			}
			execucaoUsados = false;
		} else {
			if (usadoNum == 2) {
				List <QuantProdutos> quantidadeTodosProdutos = new ArrayList<QuantProdutos>();
				for (Produto produto : empresa.getProdutos()) {
					int quantidade = 0;
					for (Cliente cliente : empresa.getClientes()) {
						for (Produto clienteProduto : cliente.getProdUsados()) {
							if(produto.equals(clienteProduto)) {
								quantidade++;
							}
						}
					}
					QuantProdutos quantidadeProduto = new QuantProdutos(produto, quantidade);
					quantidadeTodosProdutos.add(quantidadeProduto);
				}
				
				Collections.sort(quantidadeTodosProdutos, new Comparator<QuantProdutos>() {
					  public int compare(QuantProdutos qp1, QuantProdutos qp2) {
					    return qp2.getQuantUsados().compareTo(qp1.getQuantUsados());
					  }
					});
				
				if (quantidadeTodosProdutos.size() == 0) {
					System.out.println("Não há produtos cadastrados!");
				} else {
					System.out.println("Lista dos produtos mais consumidos");
					System.out.println("----------------------------------");
					for (QuantProdutos quantidadeProduto : quantidadeTodosProdutos) {
						System.out.println("Nome: " + quantidadeProduto.produto.nome);
						System.out.println("Valor: " + quantidadeProduto.produto.valor);
						System.out.println("Quantidade de vezes consumido: " + quantidadeProduto.getQuantUsados());
						System.out.println("----------------------------------");
					}
				}
				execucaoUsados = false;
			}
			else {
				System.out.println("Valor inválido! Verifique suas informações.");
			}
		}
	}
}
