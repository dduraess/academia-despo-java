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
		assertEquals(controle.informarCanal(35), (Integer)35);
	}

	@Test
	public void mudarCanalParaNrCanalInexistente() {
		assertTrue(controle.powerPressed());
		assertNotEquals(controle.informarCanal(29), (Integer)29);
	}

	@Test
	public void aumentarCanal() {
		assertTrue(controle.powerPressed());
		assertEquals(controle.informarCanal(28), (Integer)28);
		assertEquals(controle.plusChPressed(), (Integer)32);
	}

	@Test
	public void diminuirCanal() {
		assertTrue(controle.powerPressed());
		assertEquals(controle.informarCanal(28), (Integer)28);
		assertEquals(controle.lessChPressed(), (Integer)12);
	}

//	@Test
//	public void diminuirCanal() {
//		assertEquals(controle.informarCanal(28), (Integer)28);
//		assertEquals(controle.lessChPressed(), (Integer)12);
//	}

}
