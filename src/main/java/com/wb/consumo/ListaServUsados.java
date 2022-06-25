package com.wb.consumo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.modelo.Cliente;
import com.wb.modelo.QuantServico;
import com.wb.modelo.Servico;

public class ListaServUsados extends ServUsados{
	private Cliente cliente;
	private int tipo;
	
	public ListaServUsados(Cliente cliente, int tipo) {
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	@Override
	public List<Servico> listaServUsados() {
		System.out.println("Serviço(s) usado(s): ");
		if (cliente.getServUsaddos().size() == 0) {
			System.out.println("O cliente ainda não tem nenhum serviço(s) cadastrado(s)");
		}
		else {
			Set<Servico> allServicos = new HashSet<Servico>();
			allServicos.addAll(cliente.getServUsaddos());
			List<QuantServico> quantAllServicos = new ArrayList<QuantServico>();
			for (Servico servico : allServicos) {
				int quant = 0;
				for (Servico servCliente : cliente.getServUsaddos()){
					if (servico.equals(servCliente)) {
						quant++;
					}
				}
				@SuppressWarnings("unused")
				QuantServico quantServico = new QuantServico(servico, quant);
				quantAllServicos.addAll(quantAllServicos);
			}
			int l = 1;
			for (QuantServico quantServico : quantAllServicos) {
				if (tipo == 1) {
					System.out.print(l + ")");
					l++;
				}
				System.out.println(" Nome: " + quantServico.servico.nome + 
						" - Valor: " + quantServico.servico.valor + 
						" - Quantidade consumido: " +  quantServico.getQuantUsados());
			}
			if (tipo == 1) {
				List<Servico> servico = new ArrayList<Servico>();
				servico.addAll(allServicos);
				return servico;
			}
		}
		return null;
	}
	
}
