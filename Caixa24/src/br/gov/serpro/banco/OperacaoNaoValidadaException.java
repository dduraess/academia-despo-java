package br.gov.serpro.banco;

public class OperacaoNaoValidadaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperacaoNaoValidadaException (String msg) {
		super(msg);
	}
}
