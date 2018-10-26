package br.gov.serpro.ranking.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.ranking.Jogador;

public class RankingTest {
	
	private List<Jogador> jogadores;
	private Jogador neimar;
	private Jogador messy;
	private Jogador ronaldo;
	private Jogador pele;
	private Jogador tostao;
	private Jogador garrincha;
	
	@Before
	public void inicializar() {

		neimar = new Jogador("Neimar", 6);
		messy = new Jogador("Messy", 9);
		ronaldo = new Jogador("Ronaldo", 11);
		pele = new Jogador("Pelé", 100);
		tostao = new Jogador("Tostão", 10);
		garrincha = new Jogador("Garrincha", 15);
		
		jogadores = new ArrayList<>();
		
		jogadores.add(neimar);
		jogadores.add(messy);
		jogadores.add(ronaldo);
		jogadores.add(pele);
		jogadores.add(tostao);
		jogadores.add(garrincha);
	}

	@Test
	public void test() {
		Collections.sort(jogadores, Collections.reverseOrder());
		for (Jogador jogador : jogadores) {
			System.out.println("Nome: " + jogador.getNome() + "\nNr de gols: " + jogador.getNrGols() + "\n");
		}
	}

}
