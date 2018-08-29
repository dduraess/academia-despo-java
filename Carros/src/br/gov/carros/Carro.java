package br.gov.carros;

public class Carro {
	int potencia;
	int velocidade;
	String nome;
	
	void acelerar() {
		velocidade += potencia;
	}
	
	void frear() {
		velocidade = velocidade/2;
	}
	
	int getVelocidade() {
		return velocidade;
	}
	
	String getNome() {
		return nome;
	}
	
	void imprimir() {
		System.out.println("O carro"+ nome + "esta a velocidade de " + getVelocidade() + "km/h");
	}

}
