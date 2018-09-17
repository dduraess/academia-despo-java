package com.lapizzaria;

public class Pedido {
	
	int numero;
	Pizza[] listaItens;
	Entrega entrega;
	
	public Pedido(int nrPedido, Pizza[] listaItens, Entrega entregaPedido) {
		super();
		this.numero = nrPedido;
		this.listaItens = listaItens;
		this.entrega = entregaPedido;
	}
	
	public double calcularValor() {
		
		double somaItens=0;
		for (int i = 0; i < listaItens.length; i++) {
			somaItens+=listaItens[i].getPreco();
		}
		somaItens += entrega.getPreco();
		return somaItens;		
		
	}
	
	public void imprimePedido() {
		for (int i = 0; i < listaItens.length; i++) {
			System.out.println("Pizza sabor " + listaItens[i].sabor + " -> preço: " + listaItens[i].getPreco());
		}
		System.out.println("Valor da entrega: " + entrega.getPreco());
		System.out.println("Valor total: " + calcularValor());
	}

}
