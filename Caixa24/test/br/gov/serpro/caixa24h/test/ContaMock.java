package br.gov.serpro.caixa24h.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.SaldoInsuficienteException;

public class ContaMock {
	
	private String nome;
	private Double saldo;
	private String nrConta;
	private List<Historico> operacoes = new ArrayList<>();
	
	public ContaMock(String nome, Double saldo, String nrConta) {
		this.nome = nome;
		this.saldo = saldo;
		this.nrConta = nrConta;
	}
	
	public class Historico {
		
		//** TODO Jogar essa classe para fora e mudar nome diferente de historico*//
		
		private Double saldoAnterior;
		private String operacao;
		private Double valor;
		private LocalDateTime dataOperacao;
		
		public Historico(Double saldoAnterior, String operacao, Double valor) {
			this.saldoAnterior = saldoAnterior;
			this.operacao = operacao;
			this.valor = valor;
			this.dataOperacao = LocalDateTime.now();
		}
		
		public void adicionaNrContaOperacaoTransferencia (String nrContaTransferenciaEfetivada) {
			this.operacao = operacao.concat(" conta " + nrContaTransferenciaEfetivada);
		}
		
	}
	
	public String obterNrConta() {
		return nrConta;
	}
	
	public Double obterSaldo() {
		return saldo;
	}
	
	public void depositar(Double valor) {
		Historico historico = new Historico(obterSaldo(), "Depósito", valor);
		operacoes.add(historico);
		saldo = saldo + valor;
	}
	
	public void saque(Double valor) throws SaldoInsuficienteException {
		if (valor <= obterSaldo()) {
			Historico historico = new Historico(obterSaldo(), "Saque", valor);
			operacoes.add(historico);
			saldo = saldo - valor;
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
		} 
	}
	
	public void receberTransferencia(String nrContaOrigem, Double valor) {
		Historico historico = new Historico(obterSaldo(), "Crédito transferência da", valor);
		historico.adicionaNrContaOperacaoTransferencia(nrContaOrigem);
		operacoes.add(historico);
		saldo = saldo + valor;
	}
	
	public void enviarTransferencia(String nrContaDestino, Double valor) throws SaldoInsuficienteException {
		if (valor <= obterSaldo()) {
			Historico historico = new Historico(obterSaldo(), "Débito transferência para", valor);
			historico.adicionaNrContaOperacaoTransferencia(nrContaDestino);
			operacoes.add(historico);
			saldo = saldo - valor;
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}
	
	public String extrato(){
		String extratoConsolidado = "";
		for (Historico historico : operacoes) {
			extratoConsolidado = extratoConsolidado.concat(historico.dataOperacao.toString() + "; " + historico.operacao + ": " + historico.valor.toString() + "; Saldo anterior: " + historico.saldoAnterior.toString() + "\n");
		}
		return extratoConsolidado;
	}

}
