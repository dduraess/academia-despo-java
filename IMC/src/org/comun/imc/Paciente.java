package org.comun.imc;

public class Paciente {
	
	String nome;
	double peso;
	double altura;
	
	public Paciente(String nome, double peso, double altura) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}
	
	public double calcularIMC(double quilos, double metros) {
		return quilos / (metros * metros);
	}
	
	public String diagnostico() {
		
		double valorIMC = this.calcularIMC(peso, altura);
		String seuDiagnostico;
		double faixa1 = 16;
		double faixa2Sup = 16.99;
		double faixa3Inf = 17;
		double faixa3Sup = 18.49;
		double faixa4Inf = 18.50;
		double faixa4Sup = 24.99;
		double faixa5Inf = 25;
		double faixa5Sup = 29.99;
		double faixa6Inf = 30;
		double faixa6Sup = 34.99;
		double faixa7Inf = 35;
		double faixa7Sup = 39.99;
		
		if (valorIMC < faixa1) {
			seuDiagnostico = "Baixo peso muito grave";
		} else if (valorIMC >= faixa1 && valorIMC <= faixa2Sup) {
			seuDiagnostico = "Baixo peso grave";
		} else if (valorIMC >= faixa3Inf && valorIMC <= faixa3Sup) {
			seuDiagnostico = "Baixo peso";
		} else if (valorIMC >= faixa4Inf && valorIMC <= faixa4Sup) {
			seuDiagnostico = "Peso normal";
		} else if (valorIMC >= faixa5Inf && valorIMC <= faixa5Sup) {
			seuDiagnostico = "Sobrepeso";
		} else if (valorIMC >= faixa6Inf && valorIMC <= faixa6Sup) {
			seuDiagnostico = "Obesidade grau I";
		} else if (valorIMC >= faixa7Inf && valorIMC <= faixa7Sup) {
			seuDiagnostico = "Obesidade grau II";
		} else {
			seuDiagnostico = "Obesidade grau III";
		}
		
		return seuDiagnostico;

	}

}
