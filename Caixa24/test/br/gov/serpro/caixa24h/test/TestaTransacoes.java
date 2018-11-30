package br.gov.serpro.caixa24h.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.caixa24h.Banco;
import br.gov.serpro.caixa24h.Caixa24h;
import br.gov.serpro.caixa24h.Conta;
import br.gov.serpro.caixa24h.ContaInexistenteException;
import br.gov.serpro.caixa24h.SaldoInsuficienteException;

public class TestaTransacoes {
	
	private Banco bancoAlfa;
	private Caixa24h caixa24h;

	@Before
	public void inicializa() {
		List<Conta> usuarios = new ArrayList<>();
		usuarios.add(new Conta("Joao Santos",4300.00,"1234-1"));
		usuarios.add(new Conta("Antonio Braga",5400.00,"2345-2"));
		usuarios.add(new Conta("Arlindo Cruz",8650.00,"3456-3"));
		usuarios.add(new Conta("Joelma Trali",1300.00,"4567-4"));
		usuarios.add(new Conta("Jacob Goldberg",40350.00,"5678-5"));
		bancoAlfa = new Banco(usuarios);
		
	}

	@Test
	public void testarConsultarExtrato () {
		
	}

	@Test
	public void testarConsultarSaldo () {
	}

	@Test
	public void testarRealizarTransferencia() {
	}

	@Test
	public void testarRealizarDeposito () {
		
	}

	@Test
	public void testarSaque () {
		caixa24h = new Caixa24h(bancoAlfa, "3456-3");
		try {
			caixa24h.realizarSaqueCaixa24h(600.00);
		} catch (ContaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(8050.00, caixa24h.consultarSaldoCaixa24h(), 0.00);
		} catch (ContaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(caixa24h.consultarExtratoCaixa24h());
		} catch (ContaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
