package com.lapizzaria;

public class Carrinho {
	
	int nrPedido;
	double valorPedido;
	Pizza[] listaItens;
	Entrega entregaPedido;
	
	public Carrinho(int nrPedido, double valorPedido, Pizza[] listaItens, Entrega entregaPedido) {
		super();
		this.nrPedido = nrPedido;
		this.valorPedido = valorPedido;
		this.listaItens = listaItens;
		this.entregaPedido = entregaPedido;
	}
	
	

}
