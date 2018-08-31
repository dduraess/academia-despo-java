package br.org.comercio;

public class Compra {
	
	int valorTotal;
	int nrParcelas;
	
	//a vista
	public Compra (int valor) {
		valorTotal = valor;
		nrParcelas = 1;
	}
	
	//a prazo
	public Compra (int qtdParcelas, int valor) {
		nrParcelas = qtdParcelas;
		valorTotal = valor * qtdParcelas;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public int getNrParcelas() {
		return nrParcelas;
	}

	public int getValorParcela() {
		return valorTotal/nrParcelas;
	}
	

}
