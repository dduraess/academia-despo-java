package br.gov.serpro.conta;

public class ContaCorrentePremium extends ContaCorrente {
	
	private Double saldo = 0.0; 
	private static final Double LIMITE = 50.00;
	private static final Double REMUNERACAO = 1.06;
	private static final Double TAXA_DE_JUROS = 1.0;

	@Override
	public void depositar(Double valor) {
		saldo = saldo + valor * REMUNERACAO;
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
		if ((obterSaldo() + LIMITE)>= valorRetirada) {
			saldo = saldo - valorRetirada; 
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
		}
		
	}

}
