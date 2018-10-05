package org.comun.venda;

public abstract class Cartao extends Pagamento {
	
	public Cartao(int qtde) {
		super(qtde);
		// TODO Auto-generated constructor stub
	}

	public abstract void validar();

}
