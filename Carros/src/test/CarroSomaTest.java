package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.gov.carros.CarroSoma;
import br.gov.carros.CarroDeCorrida;

public class CarroSomaTest {
	
	CarroDeCorrida meuCarro;
	
	@Before 
	public void criarCarro() {
		meuCarro = new CarroSoma("Ferrari Testarossa", 10, 100);
	}
	
	@Test
	public void testCarroParado() {
		assertEquals(0, meuCarro.getVelocidade());
	}

	@Test
	public void testAcelerar() {
		meuCarro.acelerar();
		assertEquals(10, meuCarro.getVelocidade());
	}

	@Test
	public void testAcelerarAteVelocidadeMaxima() {
		for (int i = 0; i < 11; i++) {
			meuCarro.acelerar();
		}
		assertEquals(100, meuCarro.getVelocidade());
	}

	@Test
	public void testFrear() {
		meuCarro.acelerar();
		meuCarro.frear();
		assertEquals(5, meuCarro.getVelocidade());
	}

	@Test
	public void testFrearAteZero() {
		meuCarro.acelerar();
		meuCarro.frear();
		meuCarro.frear();
		meuCarro.frear();
		meuCarro.frear();
		assertEquals(0, meuCarro.getVelocidade());
	}


}
