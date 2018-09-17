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
	Moeda moeda1;
	Moeda moeda2;
	Moeda moeda3;
	Moeda moeda4;
	Moeda moeda5;
	Moeda moeda6;
	Moeda moeda7;
	Moeda moeda8;
	Moeda moeda9;

	@Before
	public void criarCofrinhoBefore() {

		cofrinho = new Cofrinho();
		cofrinho.receberMoeda(moeda1 = new Moeda(0.1));
		cofrinho.receberMoeda(moeda2 = new Moeda(0.1));
		cofrinho.receberMoeda(moeda3 = new Moeda(0.05));
		cofrinho.receberMoeda(moeda4 = new Moeda(0.25));
		cofrinho.receberMoeda(moeda5 = new Moeda(0.05));
		cofrinho.receberMoeda(moeda6 = new Moeda(0.05));
		cofrinho.receberMoeda(moeda7 = new Moeda(0.1));
		cofrinho.receberMoeda(moeda8 = new Moeda(0.1));
		cofrinho.receberMoeda(moeda9 = new Moeda(0.1));
		System.out.println("@Before");

	}

	@Test
	public void testarTotalDepositado() {
		assertEquals(0.9, cofrinho.contarValorTotalCofrinho(), 0.9);

	}

	@Test
	public void testarTotalMoedas() {
		assertEquals(cofrinho.contarMoedas(), 9);

	}

	@Test
	public void testarInformarMoedasMaiorValor() {
		assertEquals(0.25, cofrinho.informarMoedaMaiorValor(), 0.25);

	}

}
