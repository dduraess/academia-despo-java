package br.gov.serpro.banco24h;

public class ContaInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContaInexistenteException() {
		super("Conta inexistente.");
	}

	public ContaInexistenteException(Integer numeroConta) {
		super("Conta inexistente: " + numeroConta.toString() + ".");
	}

}
