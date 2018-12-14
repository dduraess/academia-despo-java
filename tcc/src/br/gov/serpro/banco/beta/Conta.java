package br.gov.serpro.banco.beta;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public abstract class Conta {
	
	protected Integer nrConta;
	protected BigDecimal saldo;
	protected List<Operacao> operacoes;
	protected BigDecimal limite;
	protected static final BigDecimal TAXA_EXTRATO = BigDecimal.valueOf(0.5);
	protected static final BigDecimal TAXA_TRANSFERENCIA = BigDecimal.valueOf(1.0);
		
	public void enviarTransferencia(BigDecimal valor)
			throws ValorExcedeLimiteException {
		if (saldo.add(limite).compareTo(valor) >= 0) {
			Operacao transferencia = new Operacao(consultaSaldo(), "Transferência", valor);
			operacoes.add(transferencia);
			saldo = saldo.subtract(valor.add(TAXA_TRANSFERENCIA));
		} else {
			throw new ValorExcedeLimiteException("Valor excede limite!", "Banco Beta", this.nrConta);
		}
		
	}

	public void saque(BigDecimal valor) throws ValorExcedeLimiteException {
		if (saldo.add(limite).compareTo(valor) >= 0) {
			Operacao saque = new Operacao(consultaSaldo(), "Saque", valor);
			operacoes.add(saque);
			saldo = saldo.subtract(calculaDebitoSaqueComTaxa(valor));
		} else {
			throw new ValorExcedeLimiteException("Valor excede limite!", "Banco Beta", this.nrConta);
		}

	}
	
	public  Integer obterNrConta () {
		return nrConta;
	}

	public BigDecimal consultaSaldo() {
		return saldo;

	}
	
	public List<Operacao> consultaExtrato() {
		saldo = saldo.subtract(TAXA_EXTRATO);
		return operacoes;
	}
	
	public void realizarDeposito(BigDecimal valor) {
		saldo = saldo.add(valor);		
	}
	
	public void receberTransferencia(BigDecimal valor) {
		saldo = saldo.add(valor);
	}
	
	private BigDecimal calculaDebitoSaqueComTaxa(BigDecimal valorSaque) {
		return valorSaque = valorSaque.multiply(BigDecimal.valueOf(1.05)).add(BigDecimal.valueOf(1.0));
	}
	
}
