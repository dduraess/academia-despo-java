package br.gov.serpro.banco.alfa;

import br.gov.serpro.banco24h.OperacaoRestritaException;

public class QuantidadeOperacoesExcedidaException extends OperacaoRestritaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuantidadeOperacoesExcedidaException (String msg) {
		super(msg);
	}

}
