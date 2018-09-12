package org.comun.cofrinho;

import java.util.Iterator;
import java.util.List;

public class Cofrinho {
	
	List<Moeda> moedasArmazenadas;
	
	public void receberMoeda(Moeda moeda) {
		moedasArmazenadas.add(moeda);
	}
	
	public int contarMoedas(List<Moeda> moedas){
		int total=0;
		for (Iterator iterator = moedas.iterator(); iterator.hasNext();) {
//			Moeda moeda = (Moeda) iterator.next();
			total++;
		} return total;
	}
	
	public void contarMoedasPorValor (List<Moeda> moedas) {
		int moedasDeCinco;
		int moedasDeDez;
		int moedasDeVinteCinco;
		for (Iterator iterator = moedas.iterator(); iterator.hasNext();) {
			Moeda moeda = (Moeda) iterator.next();
			if (moeda.valor==0.05) {
				
			}
		}
	}

}
