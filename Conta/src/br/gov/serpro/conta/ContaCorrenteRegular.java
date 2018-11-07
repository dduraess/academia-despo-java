package br.gov.serpro.conta;

public class ContaCorrenteRegular extends ContaCorrente {
	
	private Double saldo = 0.0;

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
		return 5.0;
	}

}
