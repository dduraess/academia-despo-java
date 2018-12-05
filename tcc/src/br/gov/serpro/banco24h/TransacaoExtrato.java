package br.gov.serpro.banco24h;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransacaoExtrato {

	/**
	 * Obtém a data e horário da transação.
	 * @return Data e hora da transação.
	 */
	LocalDateTime getDataHora();
	
	/**
	 * Obtém a descrição resumida da transação.
	 * @return Descrição da transação.
	 */
	String getDescricao();
	
	/**
	 * Obtém o valor da transação.
	 * @return Valor da transação.
	 */
	BigDecimal getValor();
	
	/**
	 * Obtém texto adicional opcional da transação.
	 * @return Detalhamento opcional da transação. 
	 */
	String getDetalhes();
}
