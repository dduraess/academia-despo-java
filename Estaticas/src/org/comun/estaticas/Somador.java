package org.comun.estaticas;

public class Somador {
	
	String nome;
	int valorInstancia = 0;
	static int valorEstatica = 0;
	
	void somar() {
		valorInstancia++;
		valorEstatica++;
	}
	
	void imprimir() {
		System.out.println("Estatica: " + valorEstatica + "\n" + "Instancia: " + valorInstancia);
	}

}
