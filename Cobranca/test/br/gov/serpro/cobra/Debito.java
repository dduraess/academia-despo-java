package br.gov.serpro.cobra;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class Debito {
	
	private BigDecimal nrIdContribuinte;
	private Date inicioPA; 
	private Date fimPA;
	private Receita receita; 
	private Date Vencimento;
	private List<ParteCobravel> partesCobraveis;
	private Double valorBruto;
	private Double saldoDevedor;

	final Double calcularValorBruto() {
		return valorBruto;
	}
	abstract Double calcularSaldoDevedor();

	public enum Receita {
		CSLL,
		IRPJ,
		INSS,
		IRPF,
		ISS,
		ICMS,
		MULTA_IRPF,
		MULTA_CSLL,
	}

}
