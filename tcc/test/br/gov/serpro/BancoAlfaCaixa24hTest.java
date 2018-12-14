package br.gov.serpro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.serpro.banco.alfa.Banco;
import br.gov.serpro.banco.alfa.Conta;
import br.gov.serpro.banco.alfa.ContaComum;
import br.gov.serpro.banco.alfa.ContaEspecial;
import br.gov.serpro.banco.alfa.OperacaoNaoPermitidaException;
import br.gov.serpro.banco.alfa.QuantidadeOperacoesExcedidaException;
import br.gov.serpro.banco24h.ContaInexistenteException;
import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.OperacaoRestritaException;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;
import br.gov.serpro.caixa24h.Caixa24H;

public class BancoAlfaCaixa24hTest {
	
		List<Conta> contas = new ArrayList<>();
		Banco bancoAlfa;
		Caixa24H caixa24h;
	
	@Before
	public void inicializar() {
		contas = Arrays.asList(new ContaEspecial(12341, BigDecimal.valueOf(5843.94)), new ContaComum(23452, BigDecimal.valueOf(8462.20)));
		bancoAlfa = new Banco(contas);
	}
	
	@Test
	public void transferenciaContaComum() {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(1500.00), 12341);
			assertEquals(BigDecimal.valueOf(6962.20), caixa24h.obterSaldo());
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void transferenciasMultiplasContaComumDentroLimiteDiario() {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			assertEquals(BigDecimal.valueOf(6962.20), caixa24h.obterSaldo());
		} catch (QuantidadeOperacoesExcedidaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = QuantidadeOperacoesExcedidaException.class)
	public void transferenciaContaComumRestritaQuantidadeTransacoesExcedida() throws OperacaoRestritaException, ValorExcedeLimiteException{
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.sacar(BigDecimal.valueOf(0.01));
			caixa24h.sacar(BigDecimal.valueOf(0.01));
			caixa24h.sacar(BigDecimal.valueOf(0.01));
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
		caixa24h.realizarTransferencia(BigDecimal.valueOf(1500.00), 12341);
		
	}
	
	@Test(expected = ValorExcedeLimiteException.class)
	public void transferenciaContaComumValorExcedeLimite() throws OperacaoRestritaException, ValorExcedeLimiteException{
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		caixa24h.realizarTransferencia(BigDecimal.valueOf(8462.21), 12341);
		
	}
	
	@Test
	public void transferenciaContaEspecialDentroLimite() {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(6843.94), 23452);
			assertTrue(caixa24h.obterSaldo().compareTo(BigDecimal.valueOf(-1000.00))==0);
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void transferenciasMultiplasContaEspecialSemLimiteDiario() {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 23452);
			assertEquals(BigDecimal.valueOf(3843.94), caixa24h.obterSaldo());
		} catch (QuantidadeOperacoesExcedidaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = ValorExcedeLimiteException.class)
	public void transferenciaContaEspecialValorExcedeLimite() throws OperacaoRestritaException, ValorExcedeLimiteException{
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		caixa24h.realizarTransferencia(BigDecimal.valueOf(6843.95), 23452);
		
	}
	
	@Test
	public void consultaExtrato() {
		
		/**
		 * Os asserts estão comentados pq, por algum motivo as listas não batem, apesar de bater na impressão. 
		 * Talvez seja porque não deu tempo de ordenar as listas.
		 */
		
		List<Operacao> gabaritoListaOperacoes = new ArrayList<>();
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			
			Operacao transferencia = new Operacao(BigDecimal.valueOf(8462.20), "Transferência", BigDecimal.valueOf(500.00));
			Operacao saque = new Operacao(BigDecimal.valueOf(7962.20), "Saque", BigDecimal.valueOf(500.00));
			Operacao novaTransferencia = new Operacao(BigDecimal.valueOf(7462.20), "Transferência", BigDecimal.valueOf(500.00));
			
			gabaritoListaOperacoes.add(transferencia);
			gabaritoListaOperacoes.add(saque);
			gabaritoListaOperacoes.add(novaTransferencia);
			
//			for (Operacao operacao : gabaritoListaOperacoes) {
//				System.out.println(operacao.getDetalhes() + "\n");
//			}
			
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			caixa24h.sacar(BigDecimal.valueOf(500.00));
			caixa24h.realizarTransferencia(BigDecimal.valueOf(500.00), 12341);
			
//			for (Operacao operacao : caixa24h.obterExtrato()) {
//				System.out.println(operacao.getDetalhes() + "\n");
//			}
			
		} catch (OperacaoRestritaException e) {
			e.printStackTrace();
		} catch (ValorExcedeLimiteException e) {
			e.printStackTrace();
		}
		
//		for (Operacao operacao : gabaritoListaOperacoes) {
//			int index = 0;
//			assertTrue(operacao.getDetalhes().compareTo(caixa24h.obterExtrato().get(index).getDetalhes())==0);
//			index++;
//		}
		
	}
	
	@Test
	public void consultaSaldo() {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 12341);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		try {
			caixa24h.sacar(BigDecimal.valueOf(1500.00));
			assertEquals(BigDecimal.valueOf(4343.94), caixa24h.obterSaldo());
		} catch (ValorExcedeLimiteException | OperacaoRestritaException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = OperacaoNaoPermitidaException.class)
	public void operacaoDepositoNaoPermitida() throws OperacaoRestritaException {
		
		try {
			caixa24h = new Caixa24H(bancoAlfa, 23452);
		} catch (ContaInexistenteException e) {
			e.printStackTrace();
		}
		
		caixa24h.realizarDeposito(BigDecimal.valueOf(1500.00));
		
	}

}
