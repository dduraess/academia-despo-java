package br.gov.serpro.banco24h;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operacao implements Transacionavel, Comparable<Operacao> {
	
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
	public String[] getDetalhes() {
		String[] detalhes = new String[3];
		detalhes[0] = saldoAnterior.toString();
		detalhes[1] = descricao;
		detalhes[2] = dataOperacao.toLocalDate().toString();
		return detalhes;
	}

	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}

	@Override
	public int compareTo(Operacao o) {
		if (dataOperacao.isBefore(o.dataOperacao)) {
			return -1;
		} else if (dataOperacao.isAfter(o.dataOperacao)) {
			return 1;
		} else {
			return 0;
		}
		
	} 

}
