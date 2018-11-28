package br.gov.serpro.caixa24h.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestaTransacoes {
	
	private Banco bancoAlfa;
	private Caixa24h caixa24h;

	@Before
	public void inicializa() {
		List<Correntista> usuarios;
		bancoAlfa = new Banco(usuarios);
		caixa24h = new Caixa24h(bancoAlfa);
	}

	@Test
	public void consultarExtrato () {
		
	}

}
