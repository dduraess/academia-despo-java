package br.gov.serpro.banco24h;

public class ValorExcedeLimiteException extends Exception {

	private String nomeBanco;
	private Integer numeroConta;
	
	private static final long serialVersionUID = 1L;

	public ValorExcedeLimiteException(String mensagemErro, String nomeBanco, Integer numeroConta) {
		super(mensagemErro);
		this.nomeBanco = nomeBanco;
		this.numeroConta = numeroConta;
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}
}
