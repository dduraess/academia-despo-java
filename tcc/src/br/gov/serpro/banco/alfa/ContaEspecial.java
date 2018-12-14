package br.gov.serpro.banco.alfa;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.gov.serpro.banco24h.Operacao;
import br.gov.serpro.banco24h.ValorExcedeLimiteException;

public class ContaEspecial extends Conta {
	
	private static final BigDecimal LIMITE = BigDecimal.valueOf(1000.00); 

	public ContaEspecial (Integer nrConta, BigDecimal saldoAbertura) {
		this.nrConta = nrConta;
		this.saldo = saldoAbertura;
		this.operacoes = new ArrayList<>();
	}

	@Override
	public void enviarTransferencia(BigDecimal valor)
			throws ValorExcedeLimiteException {
		if (saldo.add(LIMITE).compareTo(valor)>=0) {
			Operacao transferencia = new Operacao(consultaSaldo(), "Transferência", valor);
			operacoes.add(transferencia);
			saldo = saldo.subtract(valor);
		} else {
			throw new ValorExcedeLimiteException ("Valor excede limite!", "Banco Alfa", this.nrConta);
		}
	}

	@Override
	public void saque(BigDecimal valor) 
			throws ValorExcedeLimiteException {
		if (saldo.add(LIMITE).compareTo(valor)>=0) {
			Operacao saque = new Operacao(consultaSaldo(), "Saque", valor);
			operacoes.add(saque);
			saldo = saldo.subtract(valor);
		} else {
			throw new ValorExcedeLimiteException ("Valor excede limite!", "Banco Alfa", this.nrConta);
		}
	}

}
