package br.gov.serpro.banco24h;

import java.time.LocalDate;
import java.util.List;

public abstract class Extrato {

	private LocalDate dataInicioPeriodo;
	private LocalDate dataFimPeriodo;
	
	
	public Extrato(LocalDate dataInicioPeriodo, LocalDate dataFimPeriodo) {
		super();
		this.dataInicioPeriodo = dataInicioPeriodo;
		this.dataFimPeriodo = dataFimPeriodo;
	}

	public abstract void adicionarTransacaoExtrato(TransacaoExtrato transacaoExtrato);
	
	public abstract List<TransacaoExtrato> listaTransacoesExtrato();
	
	public LocalDate getDataInicioPeriodo() {
		return dataInicioPeriodo;
	}
	public LocalDate getDataFimPeriodo() {
		return dataFimPeriodo;
	}
	
	 
}
