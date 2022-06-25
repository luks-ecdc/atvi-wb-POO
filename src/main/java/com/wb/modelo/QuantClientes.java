package com.wb.modelo;

public class QuantClientes {
	public Cliente cliente;
	private Integer quantUsados;
	private Double valorGasto;
	
	public QuantClientes(Cliente cliente, Integer quantUsados) {
		this.cliente = cliente;
		this.quantUsados = quantUsados;
	}
	public QuantClientes(Cliente cliente, Double valorGasto) {
		this.cliente = cliente;
		this.valorGasto = valorGasto;
	}
	public Integer getQuantUsados() {
		return quantUsados;
	}
	public void setQuantUsados(Integer quantUsados) {
		this.quantUsados = quantUsados;
	}
	public Double getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}
}
