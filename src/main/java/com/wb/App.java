package com.wb;

import com.wb.app.AppCliente;
import com.wb.app.AppOthers;
import com.wb.app.AppProd;
import com.wb.app.AppServ;
import com.wb.app.Cad;
import com.wb.app.ToDo;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty!");
		Empresa empresa = new Empresa();
		ToDo cadastros = new Cad(empresa);
		cadastros.executar();
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nO que deseja consultar:");
			System.out.println("1 - Central de Clientes");
			System.out.println("2 - Central de Serviços");
			System.out.println("3 - Central de Produtos");
			System.out.println("4 - Outras funções");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("\nAté mais!");
				break;
			case 1:
				AppCliente appCliente = new AppCliente(empresa);
				appCliente.executar();
				break;	
			case 2:
				AppServ appServico = new AppServ(empresa);
				appServico.executar();
				break;		
			case 3:
				AppProd appProduto = new AppProd(empresa);
				appProduto.executar();
				break;	
			case 4:
				AppOthers appOutro = new AppOthers(empresa);
				appOutro.executar();
				break;
			default:
				System.out.println("Operação não entendida.");
			}
		}
	}
}