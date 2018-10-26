package br.gov.serpro.ranking;

import java.util.Collection;

public class Jogador implements Comparable<Jogador> {
	
	private String nome;
	private Integer nrGols;
	
	public Jogador(String nome, Integer nrGols) {
		super();
		this.nome = nome;
		this.nrGols = nrGols;
	}

	@Override
	public int compareTo(Jogador o) {
		if (nrGols > o.nrGols) {
			return 1;
		} 
		if (nrGols < o.nrGols) {
			return -1;
		} return 0;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNrGols() {
		return nrGols;
	}

}
