package br.gov.serpro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.banco.beta.Banco;
import br.gov.serpro.banco.beta.Conta;
import br.gov.serpro.banco.beta.ContaComum;
import br.gov.serpro.banco.beta.ContaPremium;
import br.gov.serpro.banco.beta.QuantidadeOperacoesExcedidaException;
import br.gov.serpro.banco24h.ContaInexistenteException;
import br.gov.serpro.banco24h.OperacaoRestritaException;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;
import br.gov.serpro.caixa24h.Caixa24H;

public class BancoBetaCaixa24hTest {

	List<Conta> contas = new ArrayList<>();
	Banco bancoBeta;
	Caixa24H caixa24h;

	@Before
	public void inicializar() {
		contas = Arrays.asList(new ContaPremium(12341, BigDecimal.valueOf(5843.94)), new ContaComum(23452, BigDecimal.valueOf(8462.20)));
		bancoBeta = new Banco(contas);
	}

	@Test
	public void consultaExtratoComumComTaxa() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		caixa24h.obterExtrato();
		assertEquals(BigDecimal.valueOf(8461.70), caixa24h.obterSaldo());

	}

	@Test
	public void consultaExtratoPremiumComTaxa() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		caixa24h.obterExtrato();
		assertEquals(BigDecimal.valueOf(5843.44), caixa24h.obterSaldo());

	}

	@Test
	public void transferenciaPremiumComTaxa() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(1500.00), 12341);
			assertEquals(BigDecimal.valueOf(6961.20), caixa24h.obterSaldo());
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		assertEquals(BigDecimal.valueOf(7343.94), caixa24h.obterSaldo());


	}

		@Test
		public void transferenciaComumComTaxa() {

			try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(1500.00), 23452);
			assertEquals(BigDecimal.valueOf(4342.94), caixa24h.obterSaldo());
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		assertEquals(BigDecimal.valueOf(9962.20), caixa24h.obterSaldo());

	}

	@Test
	public void saqueComTaxa() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.sacar(BigDecimal.valueOf(500.00));
			Boolean testaValores = BigDecimal.valueOf(7936.20).compareTo(caixa24h.obterSaldo()) == 0;
			assertTrue(testaValores);
		} catch (QuantidadeOperacoesExcedidaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void operacoesMultiplasContaComumDentroLimiteDiario() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			caixa24h.sacar(BigDecimal.valueOf(500.00));
			Boolean testaValores = BigDecimal.valueOf(7435.20).compareTo(caixa24h.obterSaldo()) == 0;
			assertTrue(testaValores);
		} catch (QuantidadeOperacoesExcedidaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = QuantidadeOperacoesExcedidaException.class)
	public void transferenciaContaComumRestritaQuantidadeTransacoesExcedida()
			throws OperacaoRestritaException, ValorExcedeLimiteException {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.sacar(BigDecimal.valueOf(0.01));
			caixa24h.sacar(BigDecimal.valueOf(0.01));
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

		caixa24h.realizarTransferencia(BigDecimal.valueOf(1500.00), 12341);

	}

	@Test(expected = ValorExcedeLimiteException.class)
	public void transferenciaContaComumValorExcedeLimite()
			throws OperacaoRestritaException, ValorExcedeLimiteException {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		caixa24h.realizarTransferencia(BigDecimal.valueOf(8662.21), 12341);

	}

	@Test
	public void transferenciaContaPremiumDentroLimite() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(10843.94), 23452);
			Boolean testaValores = BigDecimal.valueOf(-5001.00).compareTo(caixa24h.obterSaldo()) == 0;
			assertTrue(testaValores);
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void operacoesMultiplasContaPremiumSemLimiteDiario() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			assertEquals(BigDecimal.valueOf(3839.94), caixa24h.obterSaldo());
		} catch (QuantidadeOperacoesExcedidaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = ValorExcedeLimiteException.class)
	public void operacaoValorExcedeLimiteContaPremium()
			throws OperacaoRestritaException, ValorExcedeLimiteException {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		caixa24h.realizarTransferencia(BigDecimal.valueOf(10843.95), 23452);

	}

	@Test
	public void consultaSaldoPremium() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}

		try {
			caixa24h.sacar(BigDecimal.valueOf(1500.00));
			Boolean testaValores = BigDecimal.valueOf(4267.94).compareTo(caixa24h.obterSaldo()) == 0;
			assertTrue(testaValores);
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void operacaoDepositoComum() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarDeposito(BigDecimal.valueOf(1500.00));
			assertEquals(BigDecimal.valueOf(9962.20), caixa24h.obterSaldo());			
		} catch (OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void operacaoDepositoPremium() {

		try {
			caixa24h = new Caixa24H(bancoBeta, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarDeposito(BigDecimal.valueOf(1500.00));
			assertEquals(BigDecimal.valueOf(7343.94), caixa24h.obterSaldo());			
		} catch (OperacaoRestritaException e) {
			e.printStackTrace();
		}

	}

}
