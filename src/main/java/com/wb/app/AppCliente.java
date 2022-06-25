package com.wb.app;

import com.wb.atualizacao.Att;
import com.wb.atualizacao.AttCliente;
import com.wb.cadastros.Add;
import com.wb.cadastros.AddProd;
import com.wb.cadastros.AddServ;
import com.wb.cadastros.CadCliente;
import com.wb.excluir.DeleteCliente;
import com.wb.excluir.Excluir;
import com.wb.excluir.RemovedProduto;
import com.wb.excluir.RemovedServico;
import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.Empresa;

public class AppCliente {
	private Empresa empresa;
	private Entrada entrada;

	public AppCliente(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar todos os clientes");
			System.out.println("3 - Atualizar dados de um cliente");
			System.out.println("4 - Excluir cliente");
			System.out.println("5 - Adicionar um serviço consumido por um cliente");
			System.out.println("6 - Adicionar um produto consumido por um cliente");
			System.out.println("7 - Remover um serviço consumido por um cliente");
			System.out.println("8 - Remover um produto consumido por um cliente");
			System.out.println("0 - Voltar para tela inicial");	
			int operacao = entrada.receberNumeroInteiro();
			int operacaoFinal = operacao;
			
			if (operacao == -1) {
				operacaoFinal = -2;
			}
			if (operacao >= 2 && operacao <= 8 && empresa.getClientes().size() == 0) {
				System.out.println("Não há clientes cadastrados!");
				operacaoFinal = -1;
			}
			if ((operacao == 5 || operacao == 7) && empresa.getServicos().size() == 0) {
				System.out.println("Não há serviços cadastrados!");
				operacaoFinal = -1;
			} 
			if ((operacao == 6 || operacao == 8) && empresa.getProdutos().size() == 0) {
				System.out.println("Não há produtos cadastros!");
				operacaoFinal = -1;
			}
			
			switch(operacaoFinal) {
			case -1:
				break;
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Add cadastroCliente = new CadCliente(empresa.getClientes());
				cadastroCliente.cadastrar();
				break;
			case 2:
				Lista listagemClientes = new ListaAllClientes(empresa.getClientes(), 0);
				listagemClientes.lista();
				break;
			case 3:
				Att atualizarClientes = new AttCliente(empresa.getClientes());
				atualizarClientes.atualizar();
				break;
			case 4:
				Excluir excluirCliente = new DeleteCliente(empresa.getClientes());
				excluirCliente.excluir();
				break;
			case 5:
				Add adicionarServico = new AddServ(empresa.getClientes(), empresa.getServicos());
				adicionarServico.cadastrar();
				break;
			case 6:
				Add adicionarProduto = new AddProd(empresa.getClientes(), empresa.getProdutos());
				adicionarProduto.cadastrar();
				break;
			case 7:
				Excluir removerServico = new RemovedServico(empresa.getClientes());
				removerServico.excluir();
				break;
			case 8:
				Excluir removerProduto = new RemovedProduto(empresa.getClientes());
				removerProduto.excluir();
				break;
			default:
				System.out.println("Operação não entendida.");
			}
		}
	}
}
