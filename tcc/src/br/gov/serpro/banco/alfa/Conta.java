package br.gov.serpro.banco.alfa;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public abstract class Conta {
	
	protected Integer nrConta;
	protected BigDecimal saldo;
	protected List<Operacao> operacoes;
	
	public abstract void enviarTransferencia(BigDecimal valor) throws ValorExcedeLimiteException;
	public abstract void saque(BigDecimal valor) throws ValorExcedeLimiteException;
	
	public  Integer obterNrConta () {
		return nrConta;
	}

	public BigDecimal consultaSaldo() {
		return saldo;

	}
	
	public List<Operacao> consultaExtrato() {
		return operacoes;
	}
	
	public void receberTransferencia(BigDecimal valor) {
		saldo = saldo.add(valor);
	}
	
}
