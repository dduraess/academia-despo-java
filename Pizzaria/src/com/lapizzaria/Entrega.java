package com.lapizzaria;

public class Entrega {
	
	String endereco;
	double distancia;
	double preco;
	
	public Entrega(String endereco, double distancia) {
		this.endereco = endereco;
		this.distancia = distancia;
	}

	public double getPreco() {		
		return preco = distancia * 0.5;
	}

}
