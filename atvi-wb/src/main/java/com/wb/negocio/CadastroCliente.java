package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> list) {
		this.clientes = list;
		this.entrada = new Entrada();
	}

	@SuppressWarnings("unused")
	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do cliente");
		System.out.println("Por favor, informe o nome do cliente: ");
		String nome = entrada.receberTexto();
		System.out.println("Por favor, informe o nome social do cliente: ");
		String nomeSocial = entrada.receberTexto();
		System.out.println("Por favor, informe o número do CPF: ");
		String valor = entrada.receberTexto();
		System.out.println("Por favor, informe a data de emissão do cpf, no padrão dd/mm/yyyy: ");
		String data = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		System.out.println("Por favor, informe o número do RG: ");
		String valor1 = entrada.receberTexto();
		System.out.println("Por favor, informe a data de emissão do RG, padrão dd/mm/yyyy: ");
		String data1 = entrada.receberTexto();
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate dataEmissao1 = LocalDate.parse(data, formato);
		RG rg = new RG(dataEmissao1, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, cpf);
		this.clientes.add(cliente);		
	}
}