package com.wb.modelo;

public class QuantServico {
	public Servico servico;
	private Integer quantUsados;
	
	public QuantServico(Servico servico, Integer quantUsados) {
		this.servico = servico;
		this.quantUsados = quantUsados;
	}
	public Integer getQuantUsados() {
		return quantUsados;
	}
	public void setQuantUsados(Integer quantUsados) {
		this.quantUsados = quantUsados;
	}
}
