package br.gov.carros;

public class Principal {

	public static void main(String[] args) {
		Carro corcel = new Carro();
		corcel.potencia = 10;
		corcel.nome = "Corcel";
		System.out.println("Criando um novo carrro com nome: " + corcel.getNome());

	}

}
