package br.gov.serpro.banco.alfa;

import br.gov.serpro.banco24h.OperacaoRestritaException;

public class OperacaoNaoPermitidaException extends OperacaoRestritaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperacaoNaoPermitidaException(String message) {
		super(message);
	}
	
	

}
