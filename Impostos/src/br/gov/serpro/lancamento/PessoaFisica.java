package br.gov.serpro.lancamento;

import br.gov.serpro.lancamento.test.Contribuinte;

public class PessoaFisica extends Contribuinte {

	private String cpf;
	
	public PessoaFisica(String nome, Double rendimentos, String cpf) {
		super(nome, rendimentos);
		this.cpf = cpf;
	}

	@Override
	public Double calcularImposto() {
		return null;
	}

}
