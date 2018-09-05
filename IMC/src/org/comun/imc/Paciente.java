package org.comun.imc;

public class Paciente {
	
	double peso;
	double altura;
	
	public Paciente(double peso, double altura) {
		super();
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
		double faixa2 = 16.99;
		double faixa3 = 17;
		double faixa4 = 18.49;
		double faixa5 = 18.50;
		double faixa6 = 24.99;
		double faixa7 = 25;
		double faixa8 = 29.99;
		double faixa9 = 30;
		double faixa10 = 34.99;
		double faixa11 = 35;
		double faixa12 = 39.99;
		
		if (valorIMC < faixa1) {
			seuDiagnostico = "Baixo peso muito grave";
		} else if (valorIMC >= faixa1 && valorIMC <= faixa2) {
			seuDiagnostico = "Baixo peso grave";
		} else if (valorIMC >= faixa3 && valorIMC <= faixa4) {
			seuDiagnostico = "Baixo peso";
		} else if (valorIMC >= faixa5 && valorIMC <= faixa6) {
			seuDiagnostico = "Peso normal";
		} else if (valorIMC >= faixa7 && valorIMC <= faixa8) {
			seuDiagnostico = "Sobrepeso";
		} else if (valorIMC >= faixa9 && valorIMC <= faixa10) {
			seuDiagnostico = "Obesidade grau I";
		} else if (valorIMC >= faixa11 && valorIMC <= faixa12) {
			seuDiagnostico = "Obesidade grau II";
		} else {
			seuDiagnostico = "Obesidade grau III";
		}
		
		return seuDiagnostico;

	}

}
