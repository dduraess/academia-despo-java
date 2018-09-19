package Test;

import static org.junit.Assert.assertEquals;

import org.comun.cofrinho.Cofrinho;
import org.comun.cofrinho.Moeda;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestarCofrinho {

	@BeforeClass
	public static void imprimeBeforeClass() {
		System.out.println("@BeforeClass");
		
	}
	
	Cofrinho cofrinho;

	@Before
	public void criarCofrinhoBefore() {

		cofrinho = new Cofrinho();
		cofrinho.receberMoeda(new Moeda(0.1));
		cofrinho.receberMoeda(new Moeda(0.1));
		cofrinho.receberMoeda(new Moeda(0.05));
		cofrinho.receberMoeda(new Moeda(0.25));
		cofrinho.receberMoeda(new Moeda(0.05));
		cofrinho.receberMoeda(new Moeda(0.05));
		cofrinho.receberMoeda(new Moeda(0.1));
		cofrinho.receberMoeda(new Moeda(0.1));
		cofrinho.receberMoeda(new Moeda(0.1));
		System.out.println("@Before");

	}

	@Test
	public void testarTotalDepositado() {
		assertEquals(0.9, cofrinho.contarValorTotalCofrinho(), 0.0);

	}

	@Test
	public void testarTotalMoedas() {
		assertEquals(cofrinho.contarMoedas(), 9);

	}

	@Test
	public void testarInformarMoedasMaiorValor() {
		assertEquals(0.25, cofrinho.informarMoedaMaiorValor(), 0.0);

	}

}
