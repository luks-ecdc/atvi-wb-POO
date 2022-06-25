package com.wb.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class Cad extends ToDo{
	private Empresa empresa;

	public Cad(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void executar(){
		for(int l = 1; l <= 20; l++) {
			this.empresa.getProdutos().add(new Produto("Produto " + i, (i+0.25)*3));
			this.empresa.getServicos().add(new Servico("Serviço " + i, (i+0.5)*2));
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int l = 1; l <= 30; l++) {
			String genero = "";
			if(l % 2 == 0) {
				genero = "Feminino";
			} else {
				genero = "Masculino";
			}
			if (l < 10) {
				Cliente cliente = new Cliente("Lucas" + l, "Luck1nhas" + l, 
						new CPF(LocalDate.parse("18/0" + i + "/2000" + l, formato), "642083917/5" + l), genero);l
				cliente.getClass().add(new RG(LocalDate.parse("18/0" + l + "/200" + l, formato), l + "5.387.219-64"));
				cliente.getTelefones().add(new Telefone ("12", "982174389" + l));
				cliente.getTelefones().add(new Telefone ("11", "982777178" + l));
				for (int j = 0; j < l; j++) {
					if (l % 2 == 0) {
						cliente.getServUsaddos().add(this.empresa.getServicos().get(l));
					} else {
						cliente.getProdUsados().add(this.empresa.getProdutos().get(l));	
					}
				}
				this.empresa.getClientes().add(cliente);
			} else {
				Cliente cliente = new Cliente("Thamires " + l, "LadyLady" + l, 
						new CPF(LocalDate.parse(l + "/08/20" + l, formato), "123456789/" + l), genero);
				cliente.getRgs().add(new RG(LocalDate.parse(l + "/08/2010", formato), l + ".123.456-78"));
				cliente.getTelefones().add(new Telefone ("12", "982174389" + l));
				if (l == 30) {
					cliente.getRgs().add(new RG(LocalDate.parse(l + "/10/2015", formato), l + ".987.654-32"));
					cliente.getServicosConsumidos().addAll((Collection<? extends Produto>) this.empresa.getServicos().get(l-15));
					cliente.getServicosConsumidos().addAll((Collection<? extends Produto>) this.empresa.getServicos().get(l-13));
					cliente.getProdUsados().add(this.empresa.getProdutos().get(l-15));
					cliente.getProdUsados().add(this.empresa.getProdutos().get(l-13));
					cliente.getProdUsados().add(this.empresa.getProdutos().get(l-12));
				} else {
					if (l % 2 == 0) {
						cliente.getServicosConsumidos().addAll((Collection<? extends Produto>) this.empresa.getServicos().get(l-10));
						cliente.getServicosConsumidos().addAll((Collection<? extends Produto>) this.empresa.getServicos().get(l-10));	
						cliente.getProdUsados().add(this.empresa.getProdutos().get(l-10));	
					} else {
						cliente.getProdUsados().add(this.empresa.getProdutos().get(l-10));	
						cliente.getProdUsados().add(this.empresa.getProdutos().get(l-10));
						cliente.getServicosConsumidos().addAll((Collection<? extends Produto>) this.empresa.getServicos().get(l-10));
					}
				}
				this.empresa.getClientes().add(cliente);
			}	
		}
	}
}
