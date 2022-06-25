package com.wb.atualizacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.listas.Lista;
import com.wb.listas.ListaAllClientes;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class AttCliente extends Att {
	private List<Cliente> clientes;
	private Entrada entrada;

	public AttCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void atualizar() {
		System.out.println("\nIn�cio da atualiza��o de clientes");
		System.out.println("---------------------------------");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Lista listagemClientes = new ListaAllClientes(clientes, 1);
		listagemClientes.lista();
		
		int numCliente = 0;
		while (true) {
			System.out.println("Por favor, o n�mero do cliente que deseja atualizar:");
			numCliente = entrada.receberNumeroInteiro();
			if (numCliente > 0 && numCliente <= clientes.size()) {
				break;
			}
			System.out.println("N�mero de cliente inv�lido! Verifique suas informa��es.");
		}

		Cliente cliente = clientes.get(numCliente - 1);

		boolean execucaoSel = true;
		while(execucaoSel) {		
			System.out.println("\nInforma��es do cliente:");
			System.out.println("1) Nome: " + cliente.nome);
			System.out.println("2) Nome social: " + cliente.nomeSocial);
			System.out.println("3) G�nero: " + cliente.genero);
			System.out.println("4) CPF: " + cliente.getCpf().getValor() + " - Data Emiss�o: " + cliente.getCpf().getDataEmissao().format(formato));
			System.out.println("5) RG(s): ");
			for (RG rg : cliente.getRgs()) {
				System.out.println(" " + rg.getValor() + " - Data Emiss�o: "  + rg.getDataEmissao().format(formato));
			}
			System.out.println("6) Telefone(s): ");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(" (" + telefone.getDdd() + ")" + telefone.getNumero());
			}
			System.out.println("7) Data de cadastro: " + cliente.getDataCadastro().format(formato));
			System.out.println("0) Sair");
			
			System.out.println("Por favor informe o n�mero do dado que voc� deseja atualizar:");
			int numDado = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			
			switch (numDado) {
			case 0:
				System.out.println("Voltando...");
				execucaoSel = false;
				break;
			case 1:
				System.out.println("Por favor informe o novo valor do nome (Atual: " + cliente.nome + "):");
				String nome = entrada.receberTexto();
				cliente.nome = nome;
				System.out.println("Nome do cliente atualizado com sucesso!");
				break;
			case 2:
				System.out.println("Por favor informe o novo valor do nome social (Atual: " + cliente.nomeSocial + "):");
				String nomeSocial = entrada.receberTexto();
				cliente.nomeSocial = nomeSocial;
				System.out.println("Nome social do cliente atualizado com sucesso!");
				break;
			case 3:
				System.out.println("Por favor informe o novo valor do g�nero (Atual: " + cliente.genero + "):");
				String genero = "";
				boolean execucaoGenero = true;
				while(execucaoGenero) {
					System.out.println("Por favor informe o g�nero do cliente:");
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
						System.out.println("Opera��o n�o entendida.");
						}
					}
				}
				cliente.genero = genero;
				System.out.println("G�nero do cliente atualizado com sucesso!");
				break;
			case 4:
				int opCpf = 0;
				while (true) {
					System.out.println("O que deseja atualizar?");
					System.out.println("1 - Valor do CPF");
					System.out.println("2 - Data de Emiss�o do CPF");
					System.out.println("3 - Ambos");
					opCpf = entrada.receberNumeroInteiro();
					entrada.receberTexto();
					if (opCpf >= 1 && opCpf <= 3) {
						break;
					}
					System.out.println("Opera��o n�o entendida.");
				}	
				String cpfValor = "";
				String cpfData = "";
				switch (opCpf) {
				case 1:
					System.out.println("Por favor informe o novo valor de CPF (Atual: " + cliente.getCpf().getValor() + "):");
					cpfValor = entrada.receberTexto();
					cpfData = cliente.getCpf().getDataEmissao().format(formato);
					break;
				case 2:
					cpfValor = cliente.getCpf().getValor();
					System.out.println("Por favor informe o novo valor de Data de Emiss�o do CPF, no padr�o dd/mm/yyyy (Atual: " + cliente.getCpf().getDataEmissao().format(formato) + "):");
					cpfData = entrada.receberTexto();	
					break;
				case 3:
					System.out.println("Por favor informe o novo valor de CPF (Atual: " + cliente.getCpf().getValor() + "):");
					cpfValor = entrada.receberTexto();
					System.out.println("Por favor informe o novo valor de Data de Emiss�o do CPF, no padr�o dd/mm/yyyy (Atual: " + cliente.getCpf().getDataEmissao().format(formato) + "):");
					cpfData = entrada.receberTexto();	
					break;
				}
				LocalDate cpfDataFormatada = LocalDate.parse(cpfData, formato);
				CPF cpf = new CPF(cpfDataFormatada, cpfValor);
				cliente.setCpf(cpf);
				System.out.println("CPF do cliente atualizado com sucesso!");
				break;
			case 5:
				int j = 1; 
				System.out.println("Lista de RGs:");
				for (RG rg : cliente.getRgs()) {
					System.out.println(j + ") " + rg.getValor() + " - Data Emiss�o: " + rg.getDataEmissao().format(formato));
					j++;
				} 
				System.out.println("0) Adicionar um novo RG");
				int numRg = 0;
				while (true) {
					System.out.println("Por favor informe o RG que deseja atualizar:");
					numRg = entrada.receberNumeroInteiro();
					entrada.receberTexto();
					if (numRg >= 0 && numRg <= cliente.getRgs().size()) {
						break;
					}
					System.out.println("N�mero de RG inv�lido! Verifique se o n�mero inserido est� correto.");
				}
				
				if (numRg == 0) {
					System.out.println("Por favor informe o n�mero do RG: ");
					String rgValor = entrada.receberTexto();
					System.out.println("Por favor informe a Data de Emiss�o, no padr�o dd/mm/yyyy: ");
					String rgData = entrada.receberTexto();
					LocalDate rgDataFormatada = LocalDate.parse(rgData, formato);
					RG rg = new RG(rgDataFormatada, rgValor);
					cliente.getRgs().add(rg);
					System.out.println("RG do cliente adicionado com sucesso!");
				}
				else {
					RG rgAtual = cliente.getRgs().get(numRg - 1);
					int opRg = 0;
					while (true) {
						System.out.println("O que deseja atualizar?");
						System.out.println("1 - Valor do RG");
						System.out.println("2 - Data de Emiss�o do RG");
						System.out.println("3 - Ambos");
						opRg = entrada.receberNumeroInteiro();
						entrada.receberTexto();
						if (opRg >= 1 && opRg <= 3) {
							break;
						}
						System.out.println("Opera��o n�o entendida.");
					}
					String rgValor = "";
					String rgData = "";
					switch (opRg) {
					case 1:
						System.out.println("Por favor informe o novo valor do RG (Atual: " + rgAtual.getValor() + ")");
						rgValor = entrada.receberTexto();
						rgData = rgAtual.getDataEmissao().format(formato);
						break;
					case 2:
						rgValor = rgAtual.getValor();
						System.out.println("Por favor informe o novo valor da Data de Emiss�o, no padr�o dd/mm/yyyy (Atual: " + rgAtual.getDataEmissao().format(formato) + ")");
						rgData = entrada.receberTexto();
						break;
					case 3:
						System.out.println("Por favor informe o novo valor do RG (Atual: " + rgAtual.getValor() + ")");
						rgValor = entrada.receberTexto();
						System.out.println("Por favor informe o novo valor da Data de Emiss�o, no padr�o dd/mm/yyyy (Atual: " + rgAtual.getDataEmissao().format(formato) + ")");
						rgData = entrada.receberTexto();
						break;
					}
					LocalDate rgDataFormatada = LocalDate.parse(rgData, formato);
					RG rg = new RG(rgDataFormatada, rgValor);
					cliente.getRgs().set(numRg - 1, rg);
					System.out.println("RG do cliente atualizado com sucesso!");
				}
				break;
			case 6:
				int k = 1; 
				System.out.println("Lista de Telefones:");
				for (Telefone telefone : cliente.getTelefones()) {
					System.out.println(k + " - (" + telefone.getDdd() + ") "  + telefone.getNumero());
					k++;
				}
				System.out.println("0 - Adicionar um novo telefone");
				int numTelefone = 0;
				while (true) {
					System.out.println("Por favor informe o telefone que deseja atualizar:");
					numTelefone = entrada.receberNumeroInteiro();
					if (numTelefone >= 0 && numTelefone <= cliente.getTelefones().size()) {
						break;
					}
					System.out.println("N�mero de telefone inv�lido! Verifique se o n�mero inserido est� correto.");
				}
				entrada.receberTexto();
				if (numTelefone == 0) {
					System.out.println("Por favor informe o DDD do telefone: ");
					String telefoneDdd = entrada.receberTexto();
					System.out.println("Por favor informe o n�mero do telefone: ");
					String telefoneNumero = entrada.receberTexto();
					Telefone telefone = new Telefone(telefoneDdd, telefoneNumero);
					cliente.getTelefones().add(telefone);
					System.out.println("Telefone do cliente adicionado com sucesso!");
				}
				else {
					Telefone telefoneAtual = cliente.getTelefones().get(numTelefone - 1);
					int opTel = 0;
					while (true) {
						System.out.println("O que deseja atualizar?");
						System.out.println("1 - DDD do telefone");
						System.out.println("2 - N�mero de telefone");
						System.out.println("3 - Ambos");
						opTel = entrada.receberNumeroInteiro();
						entrada.receberTexto();
						if (opTel >= 1 && opTel <= 3) {
							break;
						}
						System.out.println("Opera��o n�o entendida.");
					}
					String telefoneDdd = "";
					String telefoneNumero = "";
					switch (opTel) {
					case 1:
						System.out.println("Por favor informe o novo valor do DDD (Atual: " + telefoneAtual.getDdd() + ")");
						telefoneDdd = entrada.receberTexto();
						telefoneNumero = telefoneAtual.getNumero();
						break;
					case 2:
						telefoneDdd = telefoneAtual.getDdd();
						System.out.println("Por favor informe o novo valor do n�mero do telefone (Atual: " + telefoneAtual.getNumero()+ ")");
						telefoneNumero = entrada.receberTexto();
						break;
					case 3:
						System.out.println("Por favor informe o novo valor do DDD (Atual: " + telefoneAtual.getDdd() + ")");
						telefoneDdd = entrada.receberTexto();
						System.out.println("Por favor informe o novo valor do n�mero do telefone (Atual: " + telefoneAtual.getNumero()+ ")");
						telefoneNumero = entrada.receberTexto();
						break;
					}
					Telefone telefone = new Telefone(telefoneDdd, telefoneNumero);
					cliente.getTelefones().set(numTelefone - 1, telefone);
					System.out.println("Telefone do cliente atualizado com sucesso!");
				}
				break;
			case 7:
				System.out.println("Por favor informe o novo valor de data cadastrada (Atual: " + cliente.getDataCadastro().format(formato) + "):");
				String data = entrada.receberTexto();
				LocalDate dataFormatada = LocalDate.parse(data, formato);
				cliente.setDataCadastro(dataFormatada);
				System.out.println("Data cadastrada do cliente atualizado com sucesso!");
				break;
			default:
				System.out.println("Opera��o n�o entendida");
			}
		}
	}
}
