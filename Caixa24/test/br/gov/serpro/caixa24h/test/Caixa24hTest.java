package br.gov.serpro.caixa24h.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.banco.SaldoInsuficienteException;
import br.gov.serpro.banco.Usuario;
import br.gov.serpro.caixa24h.Caixa24h;

public class Caixa24hTest {

	private BancoMock bancoAlfa;
	private Caixa24h caixa24h;
	private Usuario usuarioAtual;

	@Before
	public void inicializa() {
		List<CorrentistaMock> correntistas = new ArrayList<>();
		correntistas.add(new CorrentistaMock("Joao Santos", new ContaMock(BigDecimal.valueOf(4300.00), "1234-1")));
		correntistas.add(new CorrentistaMock("Antonio Braga", new ContaMock(BigDecimal.valueOf(5400.00), "2345-2")));
		correntistas.add(new CorrentistaMock("Arlindo Cruz", new ContaMock(BigDecimal.valueOf(8650.00), "3456-3")));
		correntistas.add(new CorrentistaMock("Joelma Trali", new ContaMock(BigDecimal.valueOf(1300.00), "4567-4")));
		correntistas.add(new CorrentistaMock("Jacob Goldberg", new ContaMock(BigDecimal.valueOf(40350.00), "5678-5")));
		usuarioAtual = correntistas.get(0);
		bancoAlfa = new BancoMock(correntistas);

	}

	@Test
	public List<Operacao> testarConsultarExtrato() {

		caixa24h = new Caixa24h(bancoAlfa, usuarioAtual);
		return caixa24h.consultarExtrato();

	}

	 @Test
	 public void testarConsultarSaldo () {
		 caixa24h.consultarSaldo();
	 }

	@Test
	public void testarRealizarTransferencia() {

		caixa24h = new Caixa24h(bancoAlfa, usuarioAtual);

		try {
			caixa24h.realizarTransferencia("4567-4", BigDecimal.valueOf(400.00));
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		assertEquals(caixa24h.consultarSaldo(), BigDecimal.valueOf(5000.00));

	}

	 @Test
	 public void testarRealizarDeposito () {
		 caixa24h.realizarDeposito(BigDecimal.valueOf(500.00));
	 }

	@Test
	public void testarSaque() {

		try {
			caixa24h.realizarSaque(BigDecimal.valueOf(600.00));
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
	}

}
