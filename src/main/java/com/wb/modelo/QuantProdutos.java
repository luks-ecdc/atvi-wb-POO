package com.wb.modelo;

public class QuantProdutos {
	public Produto produto;
	private Integer quantUsados;
	
	public QuantProdutos(Produto produto, Integer quantUsados) {
		this.produto = produto;
		this.quantUsados = quantUsados;
	}

	public Integer getQuantUsados() {
		return quantUsados;
	}

	public void setQuantUsados(Integer quantUsados) {
		this.quantUsados = quantUsados;
	}
}
