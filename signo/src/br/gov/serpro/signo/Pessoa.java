package br.gov.serpro.signo;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private LocalDate dataDeNascimento;
	private String nome;
	
	public Integer getIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataAtual, dataDeNascimento);  
		return idade.getYears();
	}
	
	public String getSigno() {
//		String input = "2015 01 02";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy MM dd" );
//		LocalDate localDate = formatter.parse ( input , LocalDate :: from );
//		Áries: 21 de março - 20 de abril
//		Touro: 21 de abril - 20 de maio
//		Gêmeos: 21 de maio - 20 de junho
//		Câncer: 21 de junho - 21 de julho
//		Leão: 22 de julho - 22 de agosto
//		Virgem: 23 de agosto - 22 de setembro
//		Libra: 23 de setembro - 22 de outubro
//		Escorpião: 23 de outubro - 21 de novembro
//		Sagitário: 22 de novembro - 21 de dezembro
//		Capricórnio: 22 de dezembro - 20 de janeiro
//		Aquário: 21 de Janeiro - 19 de fevereiro
//		Peixes: 20 de fevereiro - 20 de março
		case 
		return "";
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	

}
