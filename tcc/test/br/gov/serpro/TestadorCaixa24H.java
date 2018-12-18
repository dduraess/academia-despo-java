package br.gov.serpro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.gov.serpro.banco24h.BancoOperavel;
import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;
import br.gov.serpro.caixa24h.Caixa24H;

public class TestadorCaixa24H {
	
	/*
	 *  - Alguns testes com TO DO estão previstos para testar lógicas de contas ou bancos. Esses 
	 *  testes devem ficar nas classes de testes de cada conta ou banco concreto.
	 *  - Existem asserts redundantes/desncessários. Exemplo:
	 *      assertNotNull(saldo);
	 *      assertEquals(saldo, new BigDecimal ("3141.59"));
	 *         Apenas o segundo assert já seria suficiente.
	 *  - Existem comentários que são irrelevantes. Exemplo:
	 *  Devolve extrato da conta.
	 *  @return Extrato da conta.
	 * public Extrato obterExtrato() {
	 *  O nome do método já é capaz de indicar a intenção da ação. O javadoc, neste caso, não 
	 *  está agregando valor e poderia ser omitido.
	 *  
	 *  - Não é necessário iniciar métodos que retornem booleanos com "is" (a menos que esteja 
	 *  usando um framework que force este padrão). Talvez seja possível criar nomes mais significativos 
	 *  e/ou em portugues mesmo. Exemplo: isContaExistente poderia ser possuiContaComIdentificador
	 *  
	 */
	
	/**
	 *   
	 *
	 * @throws Exception
	 */

	@Test
	public void deveCriarCaixa24HSemErro() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;
		
		// TODO: instanciar banco e criar conta
		
		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
		assertNotNull(caixa24H);
	}
	
	@Test
	public void deveConectarComOutroBancoSemErro() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;
		BancoOperavel outroBanco = null;
		Integer outroNumeroConta = null;
		
		// TODO: instanciar banco e criar conta
		// TODO: instanciar outro banco e criar outra conta
		
		Caixa24H caixa24H;
		caixa24H = new Caixa24H(banco, numeroConta);
		
		caixa24H.conectarComBanco(outroBanco, outroNumeroConta);
	}
	
	@Test(expected = Exception.class)
	public void deveDarExcexaoDeBancoInvalido() throws Exception {
//		assertThrows(IllegalArgumentException.class, () -> new Caixa24H(null, null));
		Caixa24H banco = new Caixa24H(null, null);
	}
	
	@Test
	public void deveDarExcecaoDeContaInexistente() throws Exception {
		BancoOperavel banco = null;

		// TODO: instanciar banco e criar conta de número 1 no banco

//		assertThrows(ContaInexistenteException.class, () -> new Caixa24H(banco, Integer.valueOf(2)));
	}
	
	@Test
	public void deveObterExtratoNaoVazio() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;

		// TODO: instanciar banco e criar conta
		
		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
//		Extrato extrato = caixa24H.obterExtrato();
		List<Operacao> extrato = caixa24H.obterExtrato();
		assertNotNull(extrato);
	}
	
	@Test
	public void deveDepositarEObterSaldoCorreto() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;

		// TODO: instanciar banco e criar conta
		
		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		BigDecimal saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, new BigDecimal ("3141.59"));
	}
	
	@Test
	public void deveTransferirValorCorretamente() throws Exception {
		BancoOperavel banco = null;

		// TODO: instanciar banco e criar contas de números 1 e 2
		
		Caixa24H caixa24H = new Caixa24H(banco, Integer.valueOf(1));
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		
		caixa24H.realizarTransferencia(new BigDecimal("3138.45"), Integer.valueOf(2));
		BigDecimal saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, new BigDecimal("3.14"));
		
		caixa24H.conectarComBanco(banco, Integer.valueOf(2));
		saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, new BigDecimal("3138.45"));
	}
	
	@Test
	public void deveSacarValorCorretamente() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;

		// TODO: instanciar banco e criar conta
		
		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		caixa24H.sacar(new BigDecimal("3138.45"));
		BigDecimal novoSaldo = caixa24H.obterSaldo();
		assertEquals(novoSaldo, new BigDecimal(3.14));
		BigDecimal saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, novoSaldo);
	}

	@Test
	public void deveSacarValorCorretamenteComLimite() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;

		// TODO: instanciar banco e criar conta com limite de 1000 reais
		
		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		caixa24H.sacar(new BigDecimal("3144.14"));
		BigDecimal novoSaldo = caixa24H.obterSaldo();
		assertEquals(novoSaldo, new BigDecimal(-3.14));
		BigDecimal saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, novoSaldo);
	}

	@Test(expected = ValorExcedeLimiteException.class)
	public void deveDarErroDeLimiteExcedidoNoSaque() throws Exception {
		BancoOperavel banco = null;
		Integer numeroConta = null;

		// TODO: instanciar banco e criar conta com limite de 1000 reais

		Caixa24H caixa24H = new Caixa24H(banco, numeroConta);
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		
		try {
			caixa24H.sacar(new BigDecimal("5000"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		assertThrows(ValorExcedeLimiteException.class, () -> 
	}
	
	@Test(expected = ValorExcedeLimiteException.class)
	public void deveDarErroDeLimiteExcedidoNaTransferencia() throws Exception {
		BancoOperavel banco = null;

		// TODO: instanciar banco e criar contas 1 e 2 (limite de 1000 reais para ambas)

		Caixa24H caixa24H = new Caixa24H(banco, Integer.valueOf(1));
		caixa24H.realizarDeposito(new BigDecimal("3141.59"));
		caixa24H.realizarTransferencia(new BigDecimal("5000"), null);
//		assertThrows(ValorExcedeLimiteException.class,
//				() -> caixa24H.realizarTransferencia(new BigDecimal("5000"), Integer.valueOf(2)));
		BigDecimal saldo = caixa24H.obterSaldo();
		assertNotNull(saldo);
		assertEquals(saldo, new BigDecimal("3141.59"));
	}
}
