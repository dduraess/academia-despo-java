package br.serpro.tv.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.serpro.tv.ControleRemoto;
import br.serpro.tv.TV;

public class TesteControle {
	
	private TV tv;
	private ControleRemoto controle;

	@Before
	public void inicializar() {
		List<Integer> canais = Arrays.asList(2, 4, 5, 7, 9, 12, 28, 32, 35, 36, 39, 40, 51, 55);
		tv = new TV(canais);
		controle = new ControleRemoto(tv);
	}

	@Test
	public void mudarCanalPeloNr() {
//		assertEquals(controle.informarCanal(35), 35);
	}

}
