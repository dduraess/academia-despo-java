package br.gov.serpro.caixa24h.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.banco.ContaInexistenteException;
import br.gov.serpro.banco.SaldoInsuficienteException;
import br.gov.serpro.caixa24h.Caixa24h;

public class TestaTransacoes {
	
	//* TODO testar apenas a criação dos objetos e é possivel chamar o banco sem erro **//
	
	private BancoMock bancoAlfa;
	private Caixa24h caixa24h;

	@Before
	public void inicializa() {
		List<ContaMock> usuarios = new ArrayList<>();
		usuarios.add(new ContaMock("Joao Santos",4300.00,"1234-1"));
		usuarios.add(new ContaMock("Antonio Braga",5400.00,"2345-2"));
		usuarios.add(new ContaMock("Arlindo Cruz",8650.00,"3456-3"));
		usuarios.add(new ContaMock("Joelma Trali",1300.00,"4567-4"));
		usuarios.add(new ContaMock("Jacob Goldberg",40350.00,"5678-5"));
		bancoAlfa = new BancoMock(usuarios);
		
	}

	@Test
	public void testarConsultarExtrato () {
		
		caixa24h = new Caixa24h(bancoAlfa, "3456-3");
		
		try {
			caixa24h.realizarSaqueCaixa24h(600.00);
		} catch (ContaInexistenteException | SaldoInsuficienteException e) {
			e.printStackTrace();
		} 
		
		try {
			assertNotEquals("", caixa24h.consultarExtratoCaixa24h());
			System.out.println(caixa24h.consultarExtratoCaixa24h());
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
	}

//	@Test
//	public void testarConsultarSaldo () {
//	}

	@Test
	public void testarRealizarTransferencia() {
		
		caixa24h = new Caixa24h(bancoAlfa, "2345-2");
		
		try {
			caixa24h.realizarTransferenciaCaixa24h("4567-4", 400.00);
		} catch (ContaInexistenteException | SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		
		try {
			assertEquals(caixa24h.consultarSaldoCaixa24h(), 5000.00, 0.0);
			System.out.println(caixa24h.consultarExtratoCaixa24h());
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}	
		
		caixa24h = new Caixa24h(bancoAlfa, "4567-4");	
		
		try {
			System.out.println(caixa24h.consultarExtratoCaixa24h());
			assertEquals(caixa24h.consultarSaldoCaixa24h(), 1700.00, 0.0);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
	}

//	@Test
//	public void testarRealizarDeposito () {
//		
//	}

	@Test
	public void testarSaque () {
		
		caixa24h = new Caixa24h(bancoAlfa, "3456-3");
		
		try {
			caixa24h.realizarSaqueCaixa24h(600.00);
		} catch (ContaInexistenteException | SaldoInsuficienteException e) {
			e.printStackTrace();
		} 
		
		try {
			assertEquals(8050.00, caixa24h.consultarSaldoCaixa24h(), 0.00);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
	}

}
