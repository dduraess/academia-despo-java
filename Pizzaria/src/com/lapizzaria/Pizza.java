package com.lapizzaria;

public class Pizza {
	
	String sabor;
	double preco;
	String[] listaIngredientes;
	int qtdeIngredientes;
	
	public Pizza(String sabor, String ingrediente, String ingrediente2, String ingrediente3) {
		qtdeIngredientes=3;
		listaIngredientes = new String[qtdeIngredientes];
		this.sabor = sabor;
		this.listaIngredientes[0] = ingrediente;
		this.listaIngredientes[1] = ingrediente2;
		this.listaIngredientes[2] = ingrediente3;
		
	}

	public double getPreco() {
		preco=15.50;
		for (int i = 0; i < listaIngredientes.length; i++) {
			if (listaIngredientes[i]=="" || listaIngredientes[i]==null) {
				preco+=0;
			} else if (listaIngredientes[i]=="muzzarela") {
				preco+=8.80;
			} else if (listaIngredientes[i]=="bacon") {
				preco+=15.75;
			} else if (listaIngredientes[i]=="cebola") {
				preco+=5.9;
			} else if (listaIngredientes[i]=="aliche") {
				preco+=12;
			} else if (listaIngredientes[i]=="calabreza") {
				preco+=9.5;
			} else if (listaIngredientes[i]=="atum") {
				preco+=10;
			} 
		}
		
		return preco;
	}

}
