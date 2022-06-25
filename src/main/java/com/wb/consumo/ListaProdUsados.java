package com.wb.consumo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.QuantProdutos;

public class ListaProdUsados extends ProdUsados{
	private Cliente cliente;
	private int tipo;
	
	public ListaProdUsados(Cliente cliente, int tipo) {
		this.cliente = cliente;
		this.tipo = tipo;
	}

	@Override
	public List<Produto> listaProdUsados() {
		System.out.println("Produto(s) usado(s): ");
		if (cliente.getProdUsados().size() == 0) {
			System.out.println("Ainda não existe nenhum produto cadastrado");
		}
		else {
			Set<Produto> allProdutos = new HashSet<Produto>();
			allProdutos.addAll(cliente.getProdUsados());
			List<QuantProdutos> quantAllProdutos = new ArrayList<QuantProdutos>();
			for (Produto produto : allProdutos) {
				int quant = 0;
				for (Produto prodCliente : cliente.getProdUsados()) {
					if (produto.equals(prodCliente)) {
						quant++;
					}
				}
				QuantProdutos quantProdutos = new QuantProdutos(produto, quant);
				quantAllProdutos.add(quantProdutos);
			}
			int l = 1;
			for (QuantProdutos quantProdutos : quantAllProdutos) {
				if (tipo == 1) {
					System.out.println(l + ")");
					l++;
				}
				System.out.println("Nome: " + quantProdutos.produto.nome + "\n" + "Valor: " + quantProdutos.produto.valor + "\n" + "Quantidade usados: " + quantProdutos.getQuantUsados());
			}
			if (tipo == 1) {
				List<Produto> produtos = new ArrayList<Produto>();
				produtos.addAll(allProdutos);
				return produtos;
			}
		}
		return null;
	}
}
