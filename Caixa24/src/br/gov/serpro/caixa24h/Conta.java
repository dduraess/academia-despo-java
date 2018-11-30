package br.gov.serpro.caixa24h;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private String nome;
	private Double saldo;
	private String nrConta;
	private List<Historico> operacoes = new ArrayList<>();
	
	public Conta(String nome, Double saldo, String nrConta) {
		this.nome = nome;
		this.saldo = saldo;
		this.nrConta = nrConta;
	}
	
	public class Historico {
		
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
	
	public void receberTransferencia(Double valor) {
		Historico historico = new Historico(obterSaldo(), "Crédito transferência", valor);
		operacoes.add(historico);
		saldo = saldo + valor;
	}
	
	public void enviarTransferencia(Double valor) throws SaldoInsuficienteException {
		if (valor <= obterSaldo()) {
			Historico historico = new Historico(obterSaldo(), "Débito transferência", valor);
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
