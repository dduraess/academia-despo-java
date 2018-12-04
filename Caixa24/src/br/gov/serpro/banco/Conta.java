package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.caixa24h.test.Operacao;

public abstract class Conta {
	
	private BigDecimal saldo;
	private String nrConta;

	public String obterNrConta() {
		return nrConta;
	}
	
	public BigDecimal obterSaldo() {
		return saldo;
	}
	
	public abstract void depositar(BigDecimal valor) ;
	
	public abstract void saque(BigDecimal valor) throws SaldoInsuficienteException;
	
	public abstract void receberTransferencia(String nrContaOrigem, BigDecimal valor);
	
	public abstract void enviarTransferencia(String nrContaDestino, BigDecimal valor) throws SaldoInsuficienteException;
	
	public abstract List<Operacao> extrato();

}
