package br.gov.serpro.caixa24h.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operacao {
	
	private BigDecimal saldoAnterior;
	private String operacao;
	private BigDecimal valor;
	private LocalDateTime dataOperacao;
	
	public Operacao(BigDecimal saldoAnterior, String operacao, BigDecimal valor) {
		this.saldoAnterior = saldoAnterior;
		this.operacao = operacao;
		this.valor = valor;
		this.dataOperacao = LocalDateTime.now();
	}
	
	public void adicionaNrContaOperacaoTransferencia (String nrContaTransferenciaEfetivada) {
		this.operacao = operacao.concat(" conta " + nrContaTransferenciaEfetivada);
	}
	
}
