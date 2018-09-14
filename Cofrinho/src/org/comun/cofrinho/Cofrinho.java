package org.comun.cofrinho;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {

	List<Moeda> moedasArmazenadas = new ArrayList<>();

	private int moedasDeCinco=0;
	private int moedasDeDez=0;
	private int moedasDeVinteCinco=0;
	private int moedasDeCinquenta=0;
	private int moedasDeUm=0;
	
	public void receberMoeda(Moeda moeda) {
		moedasArmazenadas.add(moeda);
	}
	
	public int contarMoedas(List<Moeda> moedas){
		
		int total=0;
		
		for (int i = 0; i < moedas.size(); i++) {
			total++;
		} return total;
		
	}
	
	public void contarMoedasPorValor (List<Moeda> moedas) {

		if (!moedas.isEmpty()) {
			for (int i = 0; i < moedas.size(); i++) {
				if (moedas.get(i).valor.equals(0.05)) {
					moedasDeCinco++;
				} else if (moedas.get(i).valor.equals(0.1)) {
					moedasDeDez++;
				} else if (moedas.get(i).valor.equals(0.25)) {
					moedasDeVinteCinco++;
				} else if (moedas.get(i).valor.equals(0.5)) {
					moedasDeCinquenta++;
				} else if (moedas.get(i).valor.equals(1.0)) {
					moedasDeUm++;
				}
			}
		}

	}
	
	public double informarMoedaMaiorValor () {		
		
		if (moedasDeUm > 0) {
			return 1;
		} else if (moedasDeCinquenta > 0) {
			return 0.5;
		} else if (moedasDeVinteCinco > 0) {
			return 0.25;
		} else if (moedasDeDez > 0) {
			return 0.1;			
		} else if (moedasDeCinco > 0) {
			return 0.05;
		} else {
			return 0;
		}
	}
	
	public Double contarValorTotalCofrinho () {
		Double valorTotal=0.0;
		for (Moeda moeda : moedasArmazenadas) {
			valorTotal += moeda.valor; 
		} return valorTotal;
	}
	
	public void imprimirContabilidadeCofrinho () {
		contarMoedasPorValor(moedasArmazenadas);
		System.out.println("Moedas de cinco: " + moedasDeCinco);
		System.out.println("Moedas de dez: " + moedasDeDez);
		System.out.println("Moedas de vinte e cinco: " + moedasDeVinteCinco);
		System.out.println("Moedas de cinquenta: " + moedasDeCinquenta);
		System.out.println("Moedas de um: " + moedasDeUm);
		System.out.println("Total de moedas: " + contarMoedas(moedasArmazenadas));
		System.out.println("Total do cofrinho: " + contarValorTotalCofrinho());
		System.out.println("Moeda de maior valor: " + informarMoedaMaiorValor());
	}

}
