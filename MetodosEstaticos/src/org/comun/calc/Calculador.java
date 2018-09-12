package org.comun.calc;

import java.util.Random;

public class Calculador {
	
	static int maior(int primeiro, int segundo) {
		if (primeiro > segundo) {
			return primeiro;
		}
		else if (primeiro < segundo) {
			return segundo;
		} else {
			System.out.println("Os n�meros informados s�o iguais!");
			return 0;
		} 
	}
	
	static double converterCelsiusParaFarenheit (double celsius) {
		return celsius * 9 / 5 + 32;
	}
	
	static int randomicoIntervalo (int inicio, int fim) {
	
		Random random = new Random();
		Integer inteiroRandomico;
		do {
			inteiroRandomico = random.nextInt(fim);
		} while (inteiroRandomico < inicio);
		
		return inteiroRandomico;
	}
	
	static boolean validaCPF (String cpf) {
		
		byte digitos = 9;
		Integer somaProdutoDigitoAtual = 0;
		int indiceProximoCaracter = 1;
		int produtoDigitoAtual = 10;
		Integer calculoDvAtual;
		
		for (int i = 0; i < digitos; i++) {
			somaProdutoDigitoAtual += Integer.parseInt(cpf.substring(i, indiceProximoCaracter)) * produtoDigitoAtual;
			indiceProximoCaracter++;
			produtoDigitoAtual--;
		}
		
		if (somaProdutoDigitoAtual%11 < 2) {
			calculoDvAtual = 0;
		} else {
			calculoDvAtual = 11-somaProdutoDigitoAtual%11;
		}
		
		if (!calculoDvAtual.equals(Integer.parseInt(cpf.substring(9, 10)))) {
			return false;
		} else {
			
			digitos++;
			indiceProximoCaracter = 1;
			produtoDigitoAtual = 11;
			somaProdutoDigitoAtual = 0;
			
			for (int i = 0; i < digitos; i++) {
				somaProdutoDigitoAtual += Integer.parseInt(cpf.substring(i, indiceProximoCaracter)) * produtoDigitoAtual;
				indiceProximoCaracter++;
				produtoDigitoAtual--;
			}
			
			if (somaProdutoDigitoAtual%11 < 2) {
				calculoDvAtual = 0;
			} else {
				calculoDvAtual = 11-somaProdutoDigitoAtual%11;
			}
			
			if (!calculoDvAtual.equals(Integer.parseInt(cpf.substring(10, 11)))) {
				return false;
			} return true; 
		} 
		
	}
	
	static String formatarCPF (String cpf) {
		
		return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9, 11);
		
	}

}
