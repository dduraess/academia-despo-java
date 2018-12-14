package br.gov.serpro.banco.beta;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaPremium extends Conta {
	
	private static final BigDecimal LIMITE = BigDecimal.valueOf(5000.00); 

	public ContaPremium (Integer nrConta, BigDecimal saldoAbertura) {
		this.nrConta = nrConta;
		this.saldo = saldoAbertura;
		this.operacoes = new ArrayList<>();
		this.limite = LIMITE;
	}

}
