package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.carros.CarroDeCorrida;
import br.gov.carros.CarroMulti;
import br.gov.carros.CarroMulti;

public class CarroMultiTest {
	CarroDeCorrida meuCarro;
	
	@Before 
	public void criarCarro() {
		meuCarro = new CarroMulti("Maclaren m30", 1.5, 100);
	}
	
	@Test
	public void testCarroParado() {
		assertEquals(0, meuCarro.getVelocidade());
	}

	@Test
	public void testAcelerarUmaVez() {
		meuCarro.acelerar();
		assertEquals(10, meuCarro.getVelocidade());
	}

	@Test
	public void testAcelerarDuasVezes() {
		meuCarro.acelerar();
		meuCarro.acelerar();
		assertEquals(15, meuCarro.getVelocidade());
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

	@Test
	public void testAcelerarAteVelocidadeMaxima() {
		for (int i = 0; i < 11; i++) {
			meuCarro.acelerar();
		}
		assertEquals(100, meuCarro.getVelocidade());
	}

}
