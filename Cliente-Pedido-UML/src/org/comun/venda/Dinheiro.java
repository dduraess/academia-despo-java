package org.comun.venda;

public class Dinheiro extends Pagamento {
	
	private double dinheiroOferecido;

	public Dinheiro(double dinheiroOferecido) {
		super();
		this.dinheiroOferecido = dinheiroOferecido;
	}

	@Override
	public String tipoPagto() {
		return "Dinheiro";
	}
	
}
