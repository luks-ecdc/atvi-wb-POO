package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public String nomeSocial;
	private CPF cpf;
	private List<RG> rgs;
	public String genero;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private List<Produto> prodCons;
	private List<Servico> servCons;
	public Cliente(String nome, String nomeSocial, CPF cpf, String genero) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.genero = genero;
		this.rgs = new ArrayList<RG>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<Telefone>();
		this.prodCons = new ArrayList<Produto>();
		this.servCons = new ArrayList<Servico>();
	}
	public CPF getCpf() {
		return cpf;
	}
	public List<RG> getRgs() {
		return rgs;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public List<Produto> getProdUsados() {
		return prodCons;
	}
	public List<Servico> getServUsaddos() {
		return servCons;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	public void setRgs(List<RG> rgs) {
		this.rgs = rgs;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public void setProdUsados(List<Produto> prodUsados) {
		this.prodCons = prodUsados;
	}
	public void setServicosConsumidos(List<Servico> servUsados) {
		this.servCons = servUsados;
	}
	public List<Produto> getServicosConsumidos() {
		return null;
	}
}