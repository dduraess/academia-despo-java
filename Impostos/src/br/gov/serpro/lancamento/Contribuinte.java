package br.gov.serpro.lancamento;

public abstract class Contribuinte {
	
	private String nome;
	private Double rendimentos;
	
	public Contribuinte(String nome, Double rendimentos) {
		super();
		this.nome = nome;
		this.rendimentos = rendimentos;
	}
	
	public abstract Double calcularImposto();
	
	

}
