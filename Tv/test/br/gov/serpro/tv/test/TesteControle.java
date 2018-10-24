package br.gov.serpro.tv.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.tv.ControleRemoto;
import br.gov.serpro.tv.TV;

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
		assertTrue(controle.powerPressed());
		assertEquals(controle.informarNrMedia(35), (Integer)35);
	}

	@Test
	public void mudarCanalParaNrCanalInexistente() {
		assertTrue(controle.powerPressed());
		assertNotEquals(controle.informarNrMedia(29), (Integer)29);
	}

	@Test
	public void aumentarCanal() {
		assertTrue(controle.powerPressed());
		assertEquals(controle.informarNrMedia(28), (Integer)28);
		assertEquals(controle.plusChPressed(), (Integer)32);
	}

	@Test
	public void diminuirCanal() {
		assertTrue(controle.powerPressed());
		assertEquals(controle.informarNrMedia(28), (Integer)28);
		assertEquals(controle.lessChPressed(), (Integer)12);
	}

	@Test
	public void aumentarVolume() {
		assertTrue(controle.powerPressed());
		for (int i = 1; i <= 50; i++) {
			assertEquals(controle.plusVlPressed(), (Integer)i);
		}
		assertEquals(controle.plusVlPressed(), (Integer)50);
	}

	@Test
	public void diminuirVolume() {
		assertTrue(controle.powerPressed());
		for (int i = 0; i <= 50; i++) {
			controle.lessVlPressed();
		}
		for (int i = 51; i <= 0; i--) {
			assertEquals(controle.lessVlPressed(), (Integer)i);
		}
		assertEquals(controle.lessVlPressed(), (Integer)0);
	}

}
