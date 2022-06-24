package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastrosProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar todos os clientes");
			System.out.println("3 - Cadastrar produtos");
			System.out.println("4 - Cadastrar serviços");
			System.out.println("5 - Listar os serviços/produtos mais consumidos");
			System.out.println("6 - Listar os serviços/produtos mais consumidos por gênero");
			System.out.println("7 - Listar os 5º clientes que mais consumiram em valor");
			System.out.println("8 - Listar os 10º clientes que menos consumiram produtos/serviços");
			System.out.println("9 - Listar os 10º clientes que mais consumiram produtos/serviços, em quantidade");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				Cadastro cadastro = new CadastroCliente(empresa.getClientes());
				cadastro.cadastrar();
				break;
			case 2:
				Listagem listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listar();
				break;
			case 3:
				Cadastro cadastro1 = new CadastrosProduto(empresa.getProdutos());
				cadastro1.cadastrar1();
			case 4:
				Cadastro cadastro2 = new CadastroServico(empresa.getServicos());
				cadastro2.cadastrar2();
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}