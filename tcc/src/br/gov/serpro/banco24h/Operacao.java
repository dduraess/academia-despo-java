package br.gov.serpro.banco24h;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operacao implements Transacionavel {
	
	private BigDecimal saldoAnterior;
	private String descricao;
	private BigDecimal valor;	
	private LocalDateTime dataOperacao;

	public Operacao(BigDecimal saldoAnterior, String descricao, BigDecimal valor) {
		this.saldoAnterior = saldoAnterior;
		this.descricao = descricao;
		this.valor = valor;
		this.dataOperacao = LocalDateTime.now();
	}

	@Override
	/**
	 * mudei para atributo porque não sei se o metodo vai gravar a hora da transação ou somente
	 * obter a data no momento em que for chamado
	 * @see br.gov.serpro.banco24h.Transacionavel#getDataHora()
	 */
	public LocalDateTime getDataHora() {
		return dataOperacao;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public String getDetalhes() {
		return "".concat(saldoAnterior.toString() + descricao + valor.toString() + dataOperacao.toLocalDate().toString());
	}

	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	} 

}
