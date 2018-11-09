package br.gov.serpro.conta;

import br.gov.serpro.conta.test.SaldoInsuficienteException;

public abstract class ContaCorrente {
	
	public abstract void depositar(Double valor);
	public abstract Double obterSaldo();
	public abstract Double calcularTaxaJuros();
	public abstract void efetuarRetirada(double valorRetirada) throws SaldoInsuficienteException; 

}
