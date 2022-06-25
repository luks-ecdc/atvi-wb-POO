package com.wb.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.QuantClientes;

public class DezMaisUtilizados extends Lista{
	private Empresa empresa;
	private String maisOuMenos;
	private Entrada entrada;
	
	public DezMaisUtilizados(Empresa empresa, String maisOuMenos) {
		this.empresa = empresa;
		this.maisOuMenos = maisOuMenos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void lista() {
		int usadosNum = 0;
		boolean execucaoUsados = true;
		while(execucaoUsados) {
			System.out.println("Mostrar os 10 clientes que " + maisOuMenos + " utilizaram, em quantidade:");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			usadosNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (usadosNum == 1 || usadosNum == 2) {
				execucaoUsados = false;
			}
			else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
			}
		}
		
		String consumido = "";
		List <QuantClientes> quantidadeTodosClientes = new ArrayList<QuantClientes>();
		for (Cliente cliente : empresa.getClientes()) {
			if (usadosNum == 1) {
				consumido = "serviços";
				int quantServicos = cliente.getServUsaddos().size();
				QuantClientes quantClientes = new QuantClientes(cliente, quantServicos);
				quantidadeTodosClientes.add(quantClientes);
			} else {
				consumido = "produtos";
				int quantProdutos = cliente.getProdUsados().size();
				QuantClientes quantClientes = new QuantClientes(cliente, quantProdutos);
				quantidadeTodosClientes.add(quantClientes);
			}
		}
			
		if (maisOuMenos.equals("mais")) {
			Collections.sort(quantidadeTodosClientes, new Comparator<QuantClientes>() {
				  public int compare(QuantClientes qc1, QuantClientes qc2) {
				    return qc2.getQuantUsados().compareTo(qc1.getQuantUsados());
				  }
				});
		} else {
			Collections.sort(quantidadeTodosClientes, new Comparator<QuantClientes>() {
				  public int compare(QuantClientes qc1, QuantClientes qc2) {
				    return qc1.getQuantUsados().compareTo(qc2.getQuantUsados());
				  }
				});
		}
			
		int cont = 1;
		System.out.println("\nLista dos 10 clientes que " + maisOuMenos + " consumiram " + consumido);
		System.out.println("--------------------------------------------------");
		for (QuantClientes quantClientes : quantidadeTodosClientes) {
			if (cont > 10) {
				break;
			}
			System.out.println(cont + ")");
			System.out.println("Nome: " + quantClientes.cliente.nome);
			System.out.println("CPF: " + quantClientes.cliente.getCpf().getValor());
			System.out.println("Quantidade de " + consumido +  " consumidos: " + quantClientes.getQuantUsados());
			System.out.println("--------------------------------------");
			cont++;			
		}	
	}
}
