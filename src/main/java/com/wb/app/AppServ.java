package com.wb.app;

import com.wb.atualizacao.Att;
import com.wb.atualizacao.AttServ;
import com.wb.cadastros.Add;
import com.wb.cadastros.AddServ;
import com.wb.excluir.DeleteServico;
import com.wb.excluir.Excluir;
import com.wb.io.Entrada;
import com.wb.listas.AllServicos;
import com.wb.listas.Lista;
import com.wb.modelo.Empresa;

public class AppServ extends ToDo{
	private Empresa empresa;
	private Entrada entrada;

	public AppServ(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de opera��o voc� deseja fazer:");
			System.out.println("1 - Cadastrar servi�o");
			System.out.println("2 - Listar todos os servi�os");
			System.out.println("3 - Atualizar informa��es de um servi�o");
			System.out.println("4 - Excluir servi�o");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Add cadServ = new AddServ(null, empresa.getServicos());
				cadServ.cadastrar();
				break;
			case 2:
				if (empresa.getServicos().size() == 0) {
					System.out.println("N�o h� servi�os cadastrados!");
					break;
				}
				Lista listaServ = new AllServicos(empresa.getServicos());
				listaServ.lista();
				break;
			case 3:
				if (empresa.getServicos().size() == 0) {
					System.out.println("N�o h� servi�os cadastrados!");
					break;
				}
				Att attServ = new AttServ(empresa.getServicos());
				attServ.atualizar();
				break;
			case 4:
				if (empresa.getServicos().size() == 0) {
					System.out.println("N�o h� servi�os cadastrados!");
					break;
				}
				Excluir excluirServ = new DeleteServico(empresa.getServicos());
				excluirServ.excluir();
				break;
			default:
				System.out.println("Opera��o n�o entendida");
			}
		}
	}
}
