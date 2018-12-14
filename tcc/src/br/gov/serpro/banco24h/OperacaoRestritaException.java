package br.gov.serpro.banco24h;

public class OperacaoRestritaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OperacaoRestritaException (String msg) {
		super(msg + " Entre em contato com a sua agência!");
	}

}
