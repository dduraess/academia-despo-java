package br.gov.carros;

public class Principal {

	public static void main(String[] args) {
		Carro corcel = new Carro();
		corcel.potencia = 10;
		corcel.nome = "Corcel";
		System.out.println("Criando um novo carrro com nome: " + corcel.getNome());
		
		Carro carango = new Carro();
		carango.potencia = 15;
		carango.nome = "Carango";
		System.out.println("Criando um novo carrro com nome: " + carango.getNome());
		
		Carro igualCorcel = new Carro();
		igualCorcel.potencia = 10;
		igualCorcel.nome = "Corcel";
		System.out.println("Criando um novo carrro com nome: " + igualCorcel.getNome());
		
		
		corcel.acelerar();
		corcel.acelerar();
		corcel.acelerar();
		corcel.frear();
		
		carango.acelerar();
		carango.acelerar();
		
		corcel.imprimir();
		carango.imprimir();
		
		System.out.println("Imprimindo " + igualCorcel.getNome());
		
		igualCorcel.imprimir();

	}

}
