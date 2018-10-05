package org.comun.venda;

public class Dinheiro extends Pagamento {
	
	private double dinheiroOferecido;

	public Dinheiro(double dinheiroOferecido, int qtde) {
		super(qtde);
		this.dinheiroOferecido = dinheiroOferecido;
	}

	@Override
	public String tipoPagto() {
		return "Dinheiro";
	}
	
}
