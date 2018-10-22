package br.gov.serpro.cobra.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.cobra.Debito;
import br.gov.serpro.cobra.DebitoDeclarado;

public class LancamentoCobrancaTest {
	
	Debito debito;

	@Before
	public void iniciar() {
//		debito = new DebitoDeclarado();
	}
	
	@Test
	public void  debitoDeclaradoDevedor() {
		assertEquals(getClass(), debito);
	}

}
