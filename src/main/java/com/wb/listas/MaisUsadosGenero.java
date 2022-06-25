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

public class MaisUsadosGenero extends Lista{
	private Empresa empresa;
	private Entrada entrada;

	public MaisUsadosGenero(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void lista() {
		boolean execucaoUsados = true;
		int usadoNum = 0;
		while(execucaoUsados) {		
			System.out.println("Qual deseja mostrar?");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			usadoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (usadoNum == 1 || usadoNum == 2) {
				execucaoUsados = false;
			}
			else {
				System.out.println("Valor inválido. Verifique as informações.");
			}
		}

		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Qual gênero deseja ver?");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
				System.out.println("Valor inválido. Verifique suas informações.");
				}
			}
		}
		
		if (usadoNum == 1) {
			List <QuantServico> quantidadeTodosServicos = new ArrayList<QuantServico>();
			for (Servico servico : empresa.getServicos()) {
				int quantidade = 0;
				for (Cliente cliente : empresa.getClientes()) {
					for (Servico servicoCliente : cliente.getServUsaddos()) {
						if(servico.equals(servicoCliente) && cliente.genero.equals(genero)) {
							quantidade++;
						}
					}
				}
				QuantServico quantServico = new QuantServico(servico, quantidade);
				quantidadeTodosServicos.add(quantServico);
			}
			
			Collections.sort(quantidadeTodosServicos, new Comparator<QuantServico>() {
				  public int compare(QuantServico qs1, QuantServico qs2) {
				    return qs2.getQuantUsados().compareTo(qs1.getQuantUsados());
				  }
				});
			
			if(quantidadeTodosServicos.size() == 0) {
				System.out.println("Não há serviços cadastrados!");
			} else {
				System.out.println("\nLista dos serviços mais consumidos pelo gênero " + genero.toLowerCase());
				System.out.println("--------------------------------------");
				for (QuantServico quantServico : quantidadeTodosServicos) {
					System.out.println("Nome: " + quantServico.servico.nome);
					System.out.println("Quantidade de vezes consumido: " + quantServico.getQuantUsados());
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
							if(produto.equals(clienteProduto) && cliente.genero.equals(genero)) {
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
				if(quantidadeTodosProdutos.size() == 0) {
					System.out.println("Não há produtos cadastrados!");
				} else {
					System.out.println("\nLista dos produtos mais consumidos pelo gênero " + genero.toLowerCase());
					System.out.println("--------------------------------------------------------");
					for (QuantProdutos quantProdutos : quantidadeTodosProdutos) {
						System.out.println("Nome: " + quantProdutos.produto.nome);
						System.out.println("Quantidade de vezes consumido: " + quantProdutos.getQuantUsados());
						System.out.println("--------------------------------------------------------");
					}	
				}
				execucaoUsados = false;
			}
			else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
			}
		}
	}
}
