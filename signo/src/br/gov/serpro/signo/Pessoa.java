package br.gov.serpro.signo;

import java.time.LocalDate;

public class Pessoa {
	
	private LocalDate dataDeNascimento;
	private String nome;
	
	public Integer getIdade() {
		LocalDate dataAtual = LocalDate.now();
		return 1; //(Integer) dataAtual.minus(dataDeNascimento);
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	

}
