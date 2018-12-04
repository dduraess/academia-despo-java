package br.gov.serpro.banco;

public abstract class Usuario {
	
	private Conta conta;
	
	public Usuario(String nome, Conta conta) {
		this.conta = conta;
	}
	
	public String obterNrConta () {
		return this.conta.obterNrConta();
	}

}
