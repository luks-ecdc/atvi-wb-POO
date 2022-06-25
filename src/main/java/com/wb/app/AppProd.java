package com.wb.app;


import com.wb.atualizacao.Att;
import com.wb.atualizacao.AttProd;
import com.wb.cadastros.Add;
import com.wb.cadastros.AddProd;
import com.wb.excluir.DeleteProd;
import com.wb.excluir.Excluir;
import com.wb.io.Entrada;
import com.wb.listas.AllProdutos;
import com.wb.listas.Lista;
import com.wb.modelo.Empresa;

public class AppProd extends ToDo{
	private Empresa empresa;
	private Entrada entrada;

	public AppProd(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void executar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar produtos");
			System.out.println("2 - Listar todos os produtos");
			System.out.println("3 - Atualizar dados de um produto");
			System.out.println("4 - Excluir produto");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial...");
				break;
			case 1:
				Add cadProd = new AddProd(null, empresa.getProdutos());
				cadProd.cadastrar();
				break;
			case 2:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não tem produto cadastrados!");
					break;
				}
				Lista listaProd = new AllProdutos(empresa.getProdutos());
				listaProd.lista();
				break;
			case 3:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não tem produto cadastrados!");
					break;
				}
				Att attProd = new AttProd(empresa.getProdutos());
				attProd.atualizar();
				break;
			case 4:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não tem produto cadastrados!");
					break;
				}
				Excluir excluirProduto = new DeleteProd(empresa.getProdutos());
				excluirProduto.excluir();
				break;
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}
