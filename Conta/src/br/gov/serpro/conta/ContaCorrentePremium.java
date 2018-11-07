package br.gov.serpro.conta;

public class ContaCorrentePremium extends ContaCorrente {
	
	private Double saldo = 0.0; 

	@Override
	public void depositar(Double valor) {
		saldo = saldo + valor * 1.06;
	}

	@Override
	public Double obterSaldo() {
		return saldo;
	}

	@Override
	public Double calcularTaxaJuros() {
		return 1.0;
	}

}
