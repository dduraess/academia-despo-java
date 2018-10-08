package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.gov.carros.Carro;

public class CarroTest {
	
	Carro meuCarro;
	
	@Before 
	public void criarCarro() {
		meuCarro = new Carro("Ferrari Testarossa", 900, 524);
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
	public void testFrear() {
		meuCarro.acelerar();
		meuCarro.frear();
		assertEquals(5, meuCarro.getVelocidade());
	}


}
