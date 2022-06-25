package com.wb.app;

import com.wb.io.Entrada;
import com.wb.listas.DezMaisUtilizados;
import com.wb.listas.ListClienteGenero;
import com.wb.listas.Lista;
import com.wb.listas.MaisUsados;
import com.wb.listas.MaisUsadosGenero;
import com.wb.listas.MaisUsadosValor;
import com.wb.modelo.Empresa;

public class AppOthers extends ToDo{
	private Empresa empresa;
	private Entrada entrada;

	public AppOthers(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação de listagem você deseja fazer:");
			System.out.println("1 - Todos clientes (genero)");
			System.out.println("2 - Seviços/produtos mais consumidos (em geral)");
			System.out.println("3 - Serviços/produtos mais consumidos (genero)");
			System.out.println("4 - 10 clientes que mais consumiram serviços/produtos (quantidade)");
			System.out.println("5 - 10 clientes que menos consumiram serviços/produtos (quantidade)");
			System.out.println("6 - 5 clientes que mais gastaram em serviços/produtos");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			int operacaoFinal = operacao;
			if (operacao == -1) {
				operacaoFinal = -2;
			}
			if (empresa.getClientes().size() == 0 && (operacao == 1 || operacao == 4 || operacao == 5 || operacao == 6)) {
				System.out.println("Não tem clientes cadastrados.");
				operacaoFinal = -1;
			}
			if (empresa.getProdutos().size() == 0 && empresa.getServicos().size() == 0 && (operacao == 2 || operacao == 3)) {
				System.out.println("Não tem produtos/serviços cadastrados.");
				operacaoFinal = -1;
			}
			switch(operacaoFinal) {
			case -1:
				break;
			case 0:
				execucao = false;
				System.out.println("Indo para o inicio...");
				break;
			case 1:
				Lista ClienteGênero = new ListClienteGenero(empresa.getClientes());
				ClienteGênero.lista();
				break;
			case 2:
				MaisUsados MaisConsumidos = new MaisUsados(empresa);
				MaisConsumidos.lista();
				break;
			case 3:
				Lista MaisUsadosGenero = new MaisUsadosGenero(empresa);
				MaisUsadosGenero.lista();
				break;
			case 4:
				Lista DezMaisUtilizados = new DezMaisUtilizados(empresa, "mais");
				DezMaisUtilizados.lista();
				break;
			case 5:
				Lista DezMenosUtilizados = new DezMaisUtilizados(empresa, "menos");
				DezMenosUtilizados.lista();
				break;
			case 6:
				MaisUsadosValor MaisUsadosValor = new MaisUsadosValor(empresa);
				MaisUsadosValor.listar();
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
