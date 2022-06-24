package com.wb.modelo;

import java.time.LocalDate;

public class RG {
	private String valor1;
	private LocalDate dataEmissao1;
	public RG(LocalDate dataEmissao1, String valor1) {
		this.dataEmissao1 = dataEmissao1;
		this.valor1 = valor1;
	}
	public LocalDate getDataEmissao() {
		return dataEmissao1;
	}
	public String getValor() {
		return valor1;
	}
}