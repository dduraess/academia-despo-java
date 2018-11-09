package br.gov.serpro.conta;

import br.gov.serpro.conta.test.SaldoInsuficienteException;

public class ContaCorrenteRegular extends ContaCorrente {
	
	private Double saldo = 0.0;
	private static final Double TAXA_DE_JUROS = 5.0;

	@Override
	public void depositar(Double valor) {
		saldo = saldo + valor;
	}

	@Override
	public Double obterSaldo() {
		return saldo;
	}

	@Override
	public Double calcularTaxaJuros() {
		return TAXA_DE_JUROS;
	}

	@Override
	public void efetuarRetirada(double valorRetirada) throws SaldoInsuficienteException {
		if (saldo >= valorRetirada) {
			saldo = saldo - valorRetirada;
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
		}
	}

}
