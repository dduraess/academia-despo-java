package br.gov.serpro.conta;

public abstract class ContaCorrente {
	
	public abstract void depositar(Double valor);
	public abstract Double obterSaldo();
	public abstract Double calcularTaxaJuros();

}
