package br.gov.carros;

public class Carro {

	private int potencia;
	private int velocidade;
	private int velocidadeMaxima;
	private String nome;

	public Carro(String nome, int potencia, int velocidadeMaxima) {
		super();
		this.nome = nome;
		this.potencia = potencia;
		this.velocidadeMaxima = velocidadeMaxima;
		this.velocidade = 0;
	}
	
	public void acelerar() {
		velocidade += potencia;
	}
	
	public void frear() {
		velocidade = velocidade/2;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	
	public String getNome() {
		return nome;
	}

}
