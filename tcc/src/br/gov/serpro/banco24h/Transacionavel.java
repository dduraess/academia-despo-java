package br.gov.serpro.banco24h;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Transacionavel {

	/**
	 * - Sugestão de nomenclatura: Não poderia existir fora do contexto de Extrato? Talvez o nome não precise ter "Extrato" 
	 * - Classes que não têm herança explícita não precisam acionar o super() em seus construtores. Isso já é feito 
	 * implicitamente pelo Java.
	 * 
	 */

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
