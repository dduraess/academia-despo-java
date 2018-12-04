package br.gov.serpro.caixa24h.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.Conta;
import br.gov.serpro.banco.SaldoInsuficienteException;

public class ContaMock extends Conta {
	
	private BigDecimal saldo;
	private String nrConta;
	private List<Operacao> operacoes;
	
	public ContaMock(BigDecimal saldo, String nrConta) {
		this.saldo = saldo;
		this.nrConta = nrConta;
	}

	public String obterNrConta() {
		return nrConta;
	}
	
	public BigDecimal obterSaldo() {
		return saldo;
	}
	
	public void depositar(BigDecimal valor) {
//		Operacao operacao = new Operacao(obterSaldo(), "Depósito", valor);
//		operacoes.add(operacao);
//		saldo = saldo + valor;
	}
	
	public void saque(BigDecimal valor) throws SaldoInsuficienteException {
//		if (valor <= obterSaldo()) {
//			Operacao operacao = new Operacao(obterSaldo(), "Saque", valor);
//			operacoes.add(operacao);
//			saldo = saldo - valor;
//		} else {
//			throw new SaldoInsuficienteException("Saldo insuficiente!");
//		} 
	}
	
	public void receberTransferencia(String nrContaOrigem, BigDecimal valor) {
//		Operacao operacao = new Historico(obterSaldo(), "Crédito transferência da", valor);
//		operacao.adicionaNrContaOperacaoTransferencia(nrContaOrigem);
//		operacoes.add(operacao);
//		saldo = saldo + valor;
	}
	
	public void enviarTransferencia(String nrContaDestino, BigDecimal valor) throws SaldoInsuficienteException {
//		if (valor <= obterSaldo()) {
//			Operacao operacao = new Operacao(obterSaldo(), "Débito transferência para", valor);
//			operacao.adicionaNrContaOperacaoTransferencia(nrContaDestino);
//			operacoes.add(operacao);
//			saldo = saldo - valor;
//		} else {
//			throw new SaldoInsuficienteException("Saldo insuficiente");
//		}
	}
	
	public List<Operacao> extrato(){
//		String extratoConsolidado = "";
//		for (Operacao operacao : operacoes) {
//			extratoConsolidado = extratoConsolidado.concat(operacao.dataOperacao.toString() + "; " + operacao.operacao + ": " + operacao.valor.toString() + "; Saldo anterior: " + operacao.saldoAnterior.toString() + "\n");
//		}
		operacoes =  new ArrayList<>();
		return operacoes;
	}

}
