package br.gov.serpro.lancamento;

public class PessoaJuridica extends Contribuinte {
	
	private String cnpj;
	
	public PessoaJuridica (String nome, Double rendimentos, String cnpj) {
		super(nome, rendimentos);
		this.cnpj = cnpj;
	}

	@Override
	public Double calcularImposto() {
		return null;
	}

}
